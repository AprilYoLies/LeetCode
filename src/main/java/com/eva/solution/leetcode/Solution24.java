package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution24 {
    public ListNode swapPairs1(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode pre = head;
        ListNode post = head.next;
        ListNode t = null;
        head = post;
        while (true) {
            if (t != null)
                t.next = post;
            t = pre;
            pre.next = post.next;
            post.next = pre;
            pre = pre.next;
            if (pre != null && pre.next != null)
                post = pre.next;
            else break;
        }
        return head;
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nHead = head.next, cur = head, next, aNext, pre = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                break;
            }
            aNext = next.next;
            next.next = cur;
            cur.next = aNext;
            if (pre != null)
                pre.next = next;
            pre = cur;
            cur = aNext;
        }
        return nHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
//        ListNode node3 = new ListNode(4);
//        ListNode node4 = new ListNode(5);
//        ListNode node5 = new ListNode(6);
        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
        swapPairs(head);
    }
}
