package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1)
            return head;
        ListNode cur = head;
        ListNode next = head;
        ListNode head1 = head;
        int m = k;
        while (cur != null) {
            cur = cur.next;
            if (--k == 0)
                break;
        }
        if (k > 0)
            return head;
        else {
            cur = head.next;
            for (int i = 0; i < m - 1; i++) {
                next = cur.next;
                cur.next = head1;
                head1 = cur;
                cur = next;
            }
            head.next = reverseKGroup(next, m);
        }
        return head1;
    }
}
