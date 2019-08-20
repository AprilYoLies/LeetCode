package com.eva.solution.leetcode;

import java.util.Stack;

public class Solution234 {
    public static boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        while (cur != null) {
            count++;
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < (count % 2 == 0 ? count / 2 : (count - 1) / 2); i++) {
            if (stack.pop() != cur.val)
                return false;
            cur = cur.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);

        System.out.println(isPalindrome(null));
    }
}
