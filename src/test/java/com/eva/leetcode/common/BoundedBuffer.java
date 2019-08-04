package com.eva.leetcode.common;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author EvaJohnson
 * @Date 2019-08-04
 * @Email g863821569@gmail.com
 */
public class BoundedBuffer<T> {
    private ReentrantLock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();

    private Object[] arrays;

    private int idx = 0;

    private BoundedBuffer(int vol) {
        //noinspection unchecked
        this.arrays = new Object[vol + 1];
    }

    private T get() {
        try {
            lock.lock();
            if (idx == -1) {
                isEmpty.await();
            }
            isFull.signal();
            //noinspection unchecked
            return (T) arrays[idx--];
        } catch (InterruptedException ignored) {

        } finally {
            lock.unlock();
        }
        return null;
    }

    private void put(T val) {
        try {
            lock.lock();
            if (idx == arrays.length - 1) {
                isFull.await();
            }
            arrays[++idx] = val;
            isEmpty.signal();
        } catch (InterruptedException ignored) {
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(10);
        new Thread(() -> {
            for (int i = 1; i < 1000; i++) {
                buffer.put(i);
                System.out.println("Put " + i);
            }
        }).start();
        for (; ; ) {
            Thread.sleep(1000);
            buffer.get();
        }
    }
}
