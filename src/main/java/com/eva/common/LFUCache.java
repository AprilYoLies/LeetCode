package com.eva.common;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-08-13
 * @Email g863821569@gmail.com
 */
public class LFUCache {
    private final int capacity;

    private final LinkedList<KeyWrapper> usedList;

    private Map<KeyWrapper, Integer> map;

    private static class KeyWrapper implements Comparable {
        private int key;

        private int used = 0;

        private long timestamp = 0L;

        public static KeyWrapper valueOf(int key) {
            return new KeyWrapper(key);
        }

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
            if (obj == null)
                return false;
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
        this.usedList = new LinkedList<>();
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (usedList.size() == capacity) {
            Collections.sort(usedList);
            KeyWrapper keyWrapper = usedList.remove(0);
            map.remove(keyWrapper);
        }
        // write your code here
        KeyWrapper keyWrapper = new KeyWrapper(key);
        map.put(keyWrapper, value);
        Iterator<KeyWrapper> iter = usedList.iterator();
        while (iter.hasNext()) {
            KeyWrapper next = iter.next();
            if (next.key == key) {
                next.timestamp = System.nanoTime();
                return;
            }
        }
        keyWrapper.timestamp = System.nanoTime();
        usedList.add(keyWrapper);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        Iterator<KeyWrapper> iter = usedList.iterator();
        KeyWrapper next = null;
        while (iter.hasNext()) {
            next = iter.next();
            if (next.key == key) {
                break;
            }
            next = null;
        }
        if (next == null)
            return -1;
        next.used = next.used + 1;
        next.timestamp = System.nanoTime();
        return map.get(next);
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.set(33, 219);
        cache.get(39);
        cache.set(96, 56);
        cache.get(129);
        cache.get(115);
        cache.get(112);
        cache.set(3, 280);
        cache.get(40);
        cache.set(85, 193);
        cache.set(10, 10);
        cache.set(100, 136);
        cache.set(12, 66);
        cache.set(81, 261);
        cache.set(33, 58);
    }
}
