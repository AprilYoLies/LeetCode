package com.eva.solution.leetcode;

import org.junit.Test;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution25 {

    @Test
    public void testSolution() {
        // 1 2 3 4 5
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, null))))))));
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8, null))))))));
        head1 = reverseKGroup(head1, 3);
        head2 = reverseKGroup3(head2, 3);
        System.out.println(head1);
        System.out.println(head2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode to = null;
        for (int i = 0; i < k; i++) {
            if (i == 0) to = head;
            else to = to.next;
            if (to == null) return head;
            if (i == k - 1) {
                ListNode cur = head;
                head = to.next;
                while (true) {
                    ListNode next = cur.next;
                    cur.next = newHead;
                    newHead = cur;
                    if (newTail == null) newTail = newHead;
                    if (cur == to) break;
                    cur = next;
                }
            }
        }
        newTail.next = reverseKGroup(head, k);
        return newHead;
    }

    // 最后一组不够 k 个也翻转
    public ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode to = null;
        for (int i = 0; i < k; i++) {
            if (i == 0) to = head;
            else to = to.next;
            if (i == k - 1 || to.next == null) {
                ListNode cur = head;
                head = to.next;
                while (cur != null) {
                    ListNode next = cur.next;
                    cur.next = newHead;
                    newHead = cur;
                    if (newTail == null) newTail = newHead;
                    if (cur == to) break;
                    cur = next;
                }
                if (to.next == null) return newHead;
            }
        }
        newTail.next = reverseKGroup3(head, k);
        return newHead;
    }

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1 || head == null) return head;
        ListNode tail = null;
        ListNode from = head;
        ListNode to = head;
        head = null;
        for (int i = 0; i < k; i++) {
            if (from == null) break;
            if (i == 0) {
                to = from;
            } else to = to.next;
            if (to == null) {
                if (head == null) return from;
                else tail.next = from;
                return head;
            }
            if (i == k - 1) {
                ListNode cur = from;
                from = to.next;
                ListNode segHead = null;
                ListNode segTail = null;
                while (true) {
                    ListNode next = cur.next;
                    cur.next = segHead;
                    segHead = cur;
                    if (segTail == null) segTail = segHead;
                    if (cur == to) break;
                    cur = next;
                }
                if (head == null) {
                    head = segHead;
                } else {
                    tail.next = segHead;
                }
                tail = segTail;
                i = -1;
            }
        }
        if (head == null) return from;
        return head;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        ListNode cur = head;
        ListNode next = head;
        ListNode head1 = head;
        int m = k;
        while (cur != null) {
            cur = cur.next;
            if (--k == 0) break;
        }
        if (k > 0) return head;
        else {
            cur = head.next;
            for (int i = 0; i < m - 1; i++) {
                next = cur.next;
                cur.next = head1;
                head1 = cur;
                cur = next;
            }
            head.next = reverseKGroup1(next, m);
        }
        return head1;
    }
}
