package com.eva.solution.trivials;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author EvaJohnson
 * @Date 2019-08-31
 * @Email g863821569@gmail.com
 */
public class Sina2020Q2 {
    private final int capacity;
    private final LRUCache cache;

    public Sina2020Q2(int capacity) {
        this.capacity = capacity;
        this.cache = new LRUCache();
    }

    public static void main(String[] args) {
        Sina2020Q2 cache = new Sina2020Q2(2);
        cache.put(1, 2);
        cache.put(2, 2);
        cache.put(3, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

    public int get(int key) {
        Integer i = (Integer) cache.get(key);
        return i == null ? -1 : i;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    private class LRUCache extends LinkedHashMap {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }
    }
}
