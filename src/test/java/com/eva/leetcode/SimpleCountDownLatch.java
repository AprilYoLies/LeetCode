package com.eva.leetcode;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author EvaJohnson
 * @Date 2019-08-03
 * @Email g863821569@gmail.com
 */
public class SimpleCountDownLatch {

    private Sync sync;

    private SimpleCountDownLatch(int states) {
        sync = new Sync();
        sync.setStates(states);
    }

    private void countDown() {
        sync.releaseShared(1);
    }

    private void await() {
        sync.acquireShared(1);
    }

    private class Sync extends AbstractQueuedSynchronizer {
        public void setStates(int states) {
            setState(states);
        }

        @Override
        protected int tryAcquireShared(int arg) {
            int n = getState();
            if (n == 0) {
                compareAndSetState(0, arg);
                return 1;
            }
            return -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for (; ; ) {
                int n = getState();
                if (n == 0)
                    return true;
                if (compareAndSetState(n, n - arg)) {
                    return n - arg == 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int threads = 10;
        SimpleCountDownLatch latch = new SimpleCountDownLatch(threads);
        for (int i = 0; i < 10; i++) {
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
}
