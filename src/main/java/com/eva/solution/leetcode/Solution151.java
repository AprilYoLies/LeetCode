package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author EvaJohnson
 * @Date 2023-03-21 22:30:16
 * @Email g863821569@gmail.com
 */
public class Solution151 {

    @Test
    public void testReverseWords() {
        String str = " hello      the world  ";
        System.out.println(reverseWords(str));
    }

    public String reverseWords(String s) {
        String[] segs = s.split(" ");
        Stack<String> stack = new Stack<>();
        Arrays.stream(segs).iterator().forEachRemaining(seg -> {
            if (seg != null && seg.length() > 0) {
                stack.push(seg);
            }
        });
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
            sb.append(" ");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
