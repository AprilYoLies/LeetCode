package com.eva.common;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author EvaJohnson
 * @Date 2019-09-03
 * @Email g863821569@gmail.com
 */
public class DelayQueueDemo {

    public static void main(String[] args) throws InterruptedException {

        Cache cache = new Cache();

        // 添加缓存元素
        cache.put("a", "1", 5);
        cache.put("b", "2", 4);
        cache.put("c", "3", 3);

        while (true) {
            String a = cache.get("a");
            String b = cache.get("b");
            String c = cache.get("c");

            System.out.println("a : " + a + ", b : " + b + ", c : " + c);

            // 元素均过期后退出循环
            if (StringUtils.isEmpty(a) && StringUtils.isEmpty(b) && StringUtils.isEmpty(c)) {
                break;
            }

            TimeUnit.MILLISECONDS.sleep(1000);
        }

        cache.shutdown();
    }

    static class Cache implements Runnable {

        private boolean stop = false;

        private Map<String, String> itemMap = new HashMap<>();

        private DelayQueue<CacheItem> delayQueue = new DelayQueue<>();

        public Cache() {
            // 开启内部线程检测是否过期
            new Thread(this).start();
        }

        /**
         * 添加缓存
         *
         * @param key
         * @param value
         * @param exprieTime&emsp;过期时间,单位秒
         */
        public void put(String key, String value, long exprieTime) {
            CacheItem cacheItem = new CacheItem(key, exprieTime);

            // 此处忽略添加重复 key 的处理
            delayQueue.add(cacheItem);
            itemMap.put(key, value);
        }

        public String get(String key) {
            return itemMap.get(key);
        }

        public void shutdown() {
            stop = true;
        }

        @Override
        public void run() {
            while (!stop) {
                CacheItem cacheItem = delayQueue.poll();
                if (cacheItem != null) {
                    // 元素过期, 从缓存中移除
                    itemMap.remove(cacheItem.getKey());
                    System.out.println("key : " + cacheItem.getKey() + " 过期并移除");
                }
            }

            System.out.println("cache stop");
        }
    }

    static class CacheItem implements Delayed {

        private String key;

        /**
         * 过期时间(单位秒)
         */
        private long exprieTime;

        private long currentTime;

        public CacheItem(String key, long exprieTime) {
            this.key = key;
            this.exprieTime = exprieTime;
            this.currentTime = System.currentTimeMillis();
        }

        @Override
        public long getDelay(TimeUnit unit) {
            // 计算剩余的过期时间
            // 大于 0 说明未过期
            return exprieTime - TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - currentTime);
        }

        @Override
        public int compareTo(Delayed o) {
            // 过期时间长的放置在队列尾部
            if (this.getDelay(TimeUnit.MICROSECONDS) > o.getDelay(TimeUnit.MICROSECONDS)) {
                return 1;
            }
            // 过期时间短的放置在队列头
            if (this.getDelay(TimeUnit.MICROSECONDS) < o.getDelay(TimeUnit.MICROSECONDS)) {
                return -1;
            }

            return 0;
        }

        public String getKey() {
            return key;
        }
    }
}

