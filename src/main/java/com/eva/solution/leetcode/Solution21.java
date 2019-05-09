package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode curl1;
        ListNode curl2;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val) {
            head = l1;
            curl1 = l1;
            curl2 = l2;
        } else {
            head = l2;
            curl1 = l2;
            curl2 = l1;
        }
        ListNode l1next;
        ListNode l2next;
        while (true) {
            while (curl1.next != null && curl1.next.val <= curl2.val)
                curl1 = curl1.next;
            l1next = curl1.next;
            if (l1next == null) {
                curl1.next = curl2;
                break;
            }
            curl1.next = curl2;
            while (curl2.next != null && curl2.next.val <= l1next.val) {
                curl2 = curl2.next;
            }
            l2next = curl2.next;
            curl2.next = l1next;
            if (l2next == null) {
                break;
            }
            curl2 = l2next;
            curl1 = l1next;
        }
        return head;
    }
}
