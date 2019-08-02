package com.eva.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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
}
