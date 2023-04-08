package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-04-14
 * @Email g863821569@gmail.com
 */

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String ans = listAdd(l1, l2);
        ListNode head = str2ListNode(ans);
        return head;
    }

    private String listAdd(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        boolean addOne = false;
        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            if (addOne) {
                sb.append((a + b + 1) % 10);
                if (a + b + 1 >= 10)
                    addOne = true;
                else
                    addOne = false;
            } else {
                sb.append((a + b) % 10);
                if (a + b >= 10)
                    addOne = true;
                else
                    addOne = false;
            }

        }
        if (addOne)
            sb.append(1);
        return sb.toString();
    }

    private ListNode str2ListNode(String ans) {
        int g = ans.charAt(0) - 48;
        ListNode head = new ListNode(g);
        ListNode tail = head;
        for (int i = 1; i < ans.length(); i++) {
            int b = ans.charAt(i) - 48;
            tail.next = new ListNode(b);
            tail = tail.next;
        }
        return head;
    }
}