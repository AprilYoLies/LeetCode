package com.eva.leetcode;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

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
}
