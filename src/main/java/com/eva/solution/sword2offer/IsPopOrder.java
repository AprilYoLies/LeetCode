package com.eva.solution.sword2offer;

import java.util.Stack;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class IsPopOrder {
    // 1 2 3 4 5
    // 4 3 5 1 2

    private Stack<Integer> stack = new Stack<>();

    public boolean isPopOrder(int[] pushA, int[] popA) {
        int idx = 0;
        for (int i = 0; i < popA.length; i++) {
            if (!stack.isEmpty() && stack.peek() == popA[i]) {
                stack.pop();
            } else {
                while (idx < pushA.length && pushA[idx] != popA[i]) {
                    stack.push(pushA[idx++]);
                }
                if (idx == pushA.length)
                    return false;
                idx++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPopOrder isPopOrder = new IsPopOrder();
        isPopOrder.isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
    }
}
