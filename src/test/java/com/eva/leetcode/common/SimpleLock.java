package com.eva.leetcode.common;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author EvaJohnson
 * @Date 2019-08-03
 * @Email g863821569@gmail.com
 */
public class SimpleLock implements Lock {
    private Sync sync = new Sync();

    @Override
    public void lock() {
        sync.lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.unlock();
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private class Sync extends AbstractQueuedSynchronizer {
        void lock() {
            acquire(1);
        }

        void unlock() {
            release(1);
        }

        @Override
        protected boolean tryAcquire(int arg) {
            boolean b = getState() == 0;
            if (b) {
                if (compareAndSetState(0, arg)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }
            } else if (Thread.currentThread() == getExclusiveOwnerThread()) {
                setState(getState() + arg);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            int n = getState() - arg;
            if (n == 0) {
                setExclusiveOwnerThread(null);
                setState(n);
                return true;
            }
            setState(n);
            return false;
        }
    }

    public static void main(String[] args) {
        SimpleLock lock = new SimpleLock();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    System.out.println("before");
                    lock.lock();
                    System.out.println("after");
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }).start();
        }
    }
}
