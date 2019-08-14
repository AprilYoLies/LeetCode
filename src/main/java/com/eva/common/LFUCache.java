package com.eva.common;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class LFUCache {
    private final int capacity;

    private final TreeSet<KeyWrapper> usedSet;

    private Map<KeyWrapper, Integer> map;

    private static class KeyWrapper implements Comparable {
        private int key;

        private int used = 0;

        private long timestamp = 0L;

        public KeyWrapper(int key) {
            this.key = key;
        }

        @Override
        public int compareTo(Object o) {
            KeyWrapper keyWrapper = (KeyWrapper) o;
            return this.used - keyWrapper.used == 0 ? (int) (this.timestamp - keyWrapper.timestamp) : this.used - keyWrapper.used;
        }

        @Override
        public int hashCode() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof KeyWrapper))
                return false;
            KeyWrapper keyWrapper = (KeyWrapper) obj;
            return this.key == keyWrapper.key;
        }
    }


    /*
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.usedSet = new TreeSet<>();
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // 如果缓存满了
        if (usedSet.size() == capacity) {
            if (isExisted(key)) {   // 添加的元素已存在
                updateStates(key, value);
            } else {
                usedSet.pollFirst();
                addNewKey(key, value);
            }
        } else { // 直接添加
            if (isExisted(key)) {   // 添加的元素已存在
                updateStates(key, value);
            } else {
                addNewKey(key, value);
            }
        }
    }

    /**
     * 向缓存中添加新 key
     *
     * @param key   新节点 key
     * @param value 缓存值
     */
    private void addNewKey(int key, int value) {
        KeyWrapper keyWrapper = new KeyWrapper(key);
        keyWrapper.timestamp = System.nanoTime();
        usedSet.add(keyWrapper);
        map.put(keyWrapper, value);
    }

    /**
     * 更新已存在 key 的状态信息
     *
     * @param key 目标 key
     */
    private void updateStates(int key, int value) {
        Iterator<KeyWrapper> iter = usedSet.iterator();
        KeyWrapper next = null;
        while (iter.hasNext()) {
            next = iter.next();
            if (next.key == key) {
                next.used = next.used + 1;
                next.timestamp = System.nanoTime();
                map.put(next, value);
                iter.remove();
                break;
            }
        }
        usedSet.add(next);
    }

    /**
     * 看 LFU cache 中是否已经存在对应 key 的元素
     *
     * @param key 目标 key
     * @return true 存在，false 不存在
     */
    private boolean isExisted(int key) {
        for (KeyWrapper keyWrapper : usedSet) {
            if (keyWrapper.key == key)
                return true;
        }
        return false;
    }


    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        Iterator<KeyWrapper> iter = usedSet.iterator();
        KeyWrapper keyWrapper = null;
        while (iter.hasNext()) {
            KeyWrapper next = iter.next();
            if (next.key == key) {
                keyWrapper = next;
                next.used = next.used + 1;
                next.timestamp = System.nanoTime();
                iter.remove();
            }
        }
        if (keyWrapper == null)
            return -1;
        usedSet.add(keyWrapper);
        return map.get(keyWrapper);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        System.out.println(cache.get(1));
        cache.set(4, 40);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.set(5, 50);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));
    }
}