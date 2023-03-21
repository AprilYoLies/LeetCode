package com.eva.solution.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution20 {
    public boolean isValid1(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (isRight(chars[i])) {
                try {
                    if (isMatch(stack.pop(), chars[i])) ;
                    else
                        return false;
                } catch (Throwable t) {
                    return false;
                }
            } else
                stack.push(chars[i]);
        }
        return stack.empty();
    }

    @Test
    public void testIsValid() {
        System.out.println(isValid("()"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (!isRight(aChar)) {
                stack.push(aChar);
            } else {
                if (stack.empty() || !isMatch(stack.pop(), aChar)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isRight(char c) {
        return c == ']' || c == ')' || c == '}';
    }

    private boolean isMatch(char a, char b) {
        if (a == '[')
            return b == ']';
        else if (a == '{')
            return b == '}';
        else
            return b == ')';
    }
}
