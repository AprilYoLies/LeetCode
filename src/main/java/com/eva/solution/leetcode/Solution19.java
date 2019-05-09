package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        ListNode target = head;
        while (cur != null) {
            if (n >= 0) {
                n--;
            } else
                target = target.next;
            cur = cur.next;
        }
        if (n == 0) {
            head = head.next;
            return head;
        }
        target.next = target.next.next;
        return head;
    }
}
