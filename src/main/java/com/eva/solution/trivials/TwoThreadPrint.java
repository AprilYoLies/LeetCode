package com.eva.solution.trivials;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author EvaJohnson
 * @Date 2019-09-16
 * @Email g863821569@gmail.com
 */
public class TwoThreadPrint {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        ExecutorService executor = Executors.newFixedThreadPool(5, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        Object monitor = new Object();
        Runnable run1 = () -> {
            try {
                synchronized (monitor) {
                    int i = 1, c = 0;
                    while (i <= 52) {
                        System.out.println(i++);
                        c++;
                        if (c == 2 && i != 53) {
                            c = 0;
                            monitor.wait();
                        } else {
                            monitor.notify();
                        }
                    }
                }
            } catch (Exception ignored) {

            }
            cdl.countDown();
        };

        Runnable run2 = () -> {
            try {
                synchronized (monitor) {
                    char c = 'A';
                    while (c <= 'Z') {
                        System.out.println(c++);
                        monitor.notify();
                        if (c == 'Z' + 1) break;
                        monitor.wait();
                    }
                }
            } catch (Exception ignored) {
            }

            cdl.countDown();
        };
        executor.execute(run1);
        executor.execute(run2);
        cdl.await();
    }
}
