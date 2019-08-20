package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution21 {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1Cur = l1, l2Cur = l2, nHead = null, tail = null;
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        while (true) {
            if (l1Cur != null && l2Cur != null) {
                if (l1Cur.val < l2Cur.val) {
                    if (nHead == null) {
                        nHead = l1Cur;
                        tail = nHead;
                    } else {
                        tail.next = l1Cur;
                        tail = tail.next;
                    }
                    l1Cur = l1Cur.next;
                    tail.next = null;
                } else {
                    if (nHead == null) {
                        nHead = l2Cur;
                        tail = nHead;
                    } else {
                        tail.next = l2Cur;
                        tail = tail.next;
                    }
                    l2Cur = l2Cur.next;
                    tail.next = null;
                }
            } else if (l1Cur != null) {
                tail.next = l1Cur;
                break;
            } else {
                tail.next = l2Cur;
                break;
            }
        }
        return nHead;
    }
}
