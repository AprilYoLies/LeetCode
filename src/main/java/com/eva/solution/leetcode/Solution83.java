package com.eva.solution.leetcode;

public class Solution83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, next = head.next;
        while (next != null) {
            while (next != null && cur.val == next.val) {
                ListNode pre = next;
                next = next.next;
                pre.next = null;
            }
            cur.next = next;
            cur = cur.next;
            if (cur == null) break;
            next = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode nHead1 = deleteDuplicates(head);
    }
}
