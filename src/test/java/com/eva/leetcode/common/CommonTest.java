package com.eva.leetcode.common;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class CommonTest {
    @Test
    public void hashMapTest() {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> conMap = new ConcurrentHashMap<>();
        Random random = new Random(100);
//        hashMap.put(null, null);    // hash map 可以存放空元素进 map 集合
//        conMap.put(null, null); // concurrent hash map 不能存放空元素进集合
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int key = random.nextInt();
            keys.add(key);
            String value = key + "";
            hashMap.put(key, value);
        }

        for (Integer key : keys) {
            hashMap.get(key);
        }
    }

    @Test
    public void yieldTest() throws IOException {
        for (int i = 0; i < 2; i++) {
            final int n = i;
            new Thread(() -> {
                doSomething(n);
            }).start();
        }
        System.in.read();
    }

    public synchronized void doSomething(int i) {
        System.out.println("before");
        Thread.yield(); // 测试说明 yield 不会释放锁
        try {
            if (i == 0) // 测试说明线程退出时，不会唤醒 wait 在监视器锁上的线程
                wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    // 中断线程的优雅方式
    @Test
    public void interruptTest() throws InterruptedException {
        AtomicBoolean flag = new AtomicBoolean(true);
        Thread thread = new Thread(() -> {
            while (!isInterrupted()) {
                try {
                    System.out.println("before");
                    Thread.sleep(1200000);
                    System.out.println("after");
                } catch (InterruptedException e) {
                    System.out.println("----");
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
            flag.set(false);
        });
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        while (flag.get()) ;
    }

    public boolean isInterrupted() {
        return Thread.currentThread().isInterrupted();
    }

    @Test
    public void lockTest() throws IOException {
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    System.out.println("before");
                    // 默认情况下构建的是非公平锁，那么 lock.lock(); 方法实际是调用的 NonfairSync.lock 方法，在该方法中，会优先通过 cas 进行
                    // 一次 aqs state 的判断，如果能获取到锁，就直接返回。否则会调用 AbstractQueuedSynchronizer.acquire 方法，该方法中也会
                    // 会通过 cas 进行一次不公平的 state 检查，如果当前锁没有被持有，或者持有者是自己，那么就直接返回。否则就是将自己封装为 Node
                    // 追加到等待队列中，然后被 park ，等待唤醒。自己加入队列的过程中也是通过 cas 操作完成，然后被 park 的过程中还会判断是否是自己到头
                    // 结点位置了，如果是，就代表自己当前能够被唤醒了，那么就不用被 park 了，直接返回。
                    lock.lock();
                    System.out.println("after");
                } finally {
                    // 还是以非公平锁进行说明，lock.unlock(); 方法根本是调用的 AbstractQueuedSynchronizer.release 方法，该方法中会先调用
                    // tryRelease 方法，它是我们自己实现的逻辑，在这里边，ReentrantLock 选择的是如果 states 减少为 0 了，那么就说明锁释放了，
                    // 于是置空当前持有锁的线程，同时返回 true，否则，就只是对 state 进行减一操作，然后返回 false。接下来会根据返回的状态进行操作,
                    // 具体就是唤醒头结点后的第一个节点，这里的查找方式比较特别，选择的是从后向前查找的方式。
                    lock.unlock();
                }
            }).start();
        }
        System.in.read();
    }

    @Test
    public void countDownLatchTest() throws InterruptedException {
        int threads = 10;
        CountDownLatch latch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                    latch.countDown();
                } catch (InterruptedException ignored) {
                }
            }).start();
        }
        System.out.println("before");
        latch.await();
        System.out.println("after");
    }

    @Test
    public void conditionTest() throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("before");
                condition.await();
                System.out.println("after");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        try {
            Thread.sleep(1000);
            lock.lock();
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    @Test
    public void executorTest() throws IOException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        for (int i = 0; i < 15; i++) {
            executor.execute(new ExpensiveTask());
        }
        System.in.read();
    }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(0);
        }
        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        Map<String, String> cmap = new ConcurrentHashMap<>();
        cmap.put("a", "b");
        ThreadLocal<Integer> tl = new ThreadLocal<>();
        tl.set(123);
        tl.get();
        Queue<Integer> abq = new ArrayBlockingQueue<>(10);
        Queue<Integer> lbq = new LinkedBlockingQueue<>(10);
        Queue<Integer> pbq = new PriorityBlockingQueue<>(10);
        for (int i = 0; i < 11; i++) {
            abq.offer(i);
            lbq.offer(i);
            pbq.offer(i);
        }
    }

    private class ExpensiveTask implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (Exception ignored) {

            }
        }
    }

    @Test
    public void testTryFinally() {
        System.out.println(tryFinally());
    }

    private int tryFinally() {
        int a = 10;
        try {
            a = 1 / 0;
            return ++a;
        } catch (Exception e) {
            return a + 5;
        } finally {
            a = 20;
            System.out.println("finally " + a);
        }
    }

    @Test
    public void testStringIntern() {
        String str1 = new String("abc");
        String str2 = "abc";
        System.out.println(str1 == str2);
        str1 = str1.intern();
        System.out.println(str1 == str2);
    }

    @Test
    public void testCondition() throws Exception {
        ReentrantLock lock = new ReentrantLock();
        Condition cond1 = lock.newCondition();
        Semaphore s = new Semaphore(0);
        new Thread(() -> {
            try {
                lock.lock();
                cond1.await();
                System.out.println("hello world..");
            } catch (Exception ignored) {
            } finally {
                lock.unlock();
                s.release();
            }
        }).start();
        lock.lock();
        cond1.signal();
        lock.unlock();
        s.acquire();
    }

    @Test
    public void testFutureTask() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Callable<Object> c1 = () -> 1;
        Future<Object> f1 = executor.submit(c1);

        FutureTask<Integer> ft = new FutureTask<>(() -> {
            Thread.sleep(100);
            return 2;
        });
        new Thread(ft).start();

        while (!(f1.isDone() && ft.isDone())) ;
        System.out.println("finished");
    }

    @Test
    public void testCollectionPutNull() {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        list.add(1);
        list.add(null);
        list.add(null);
        map.put(1, null);
        map.put(2, null);
        map.put(null, 1);
        map.put(null, 2);
        System.out.println(map.get(1));
        set.add(null);
        set.add(null);
    }

    @Test
    public void testIntegerConvert() {
        System.out.println(Long.MAX_VALUE);
        System.out.println(convert(99999999, 99999998));
    }

    private int convert(int num, int radix) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % radix);
            num /= radix;
        }
        return Integer.parseInt(sb.reverse().toString());
    }
}
