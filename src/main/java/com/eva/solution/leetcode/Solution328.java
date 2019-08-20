package com.eva.solution.leetcode;

public class Solution328 {
    // 1 2 3 4 5 6 7 8 9
    // 1 3 5 7 9 2 4 6 8
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode oddTail = head, evenTail = head.next, cur = evenTail.next;
        while (cur != null) {
            ListNode next = cur.next;
            evenTail.next = next;
            cur.next = oddTail.next;
            oddTail.next = cur;
            oddTail = oddTail.next;

            cur = next;
            if (cur == null) break;
            evenTail.next = cur;
            evenTail = evenTail.next;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);

        head1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        oddEvenList(head1);
    }
}
