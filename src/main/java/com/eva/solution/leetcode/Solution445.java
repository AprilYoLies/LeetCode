package com.eva.solution.leetcode;

public class Solution445 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode l1Cur = l1, l2Cur = l2;
        boolean flag = false;
        while (l1Cur != null || l2Cur != null) {
            if (l1Cur != null && l2Cur != null) {
                int val = l1Cur.val + l2Cur.val + (flag ? 1 : 0);
                flag = val / 10 == 1;
                l1Cur.val = val % 10;
                if (l1Cur.next == null)
                    l1Cur.next = new ListNode(0);
                l1Cur = l1Cur.next;
                l2Cur = l2Cur.next;
            } else if (l1Cur != null) {
                if (!flag) break;
                if (l1Cur.next == null)
                    l1Cur.next = new ListNode(0);
                int val = l1Cur.val + 1;
                flag = val / 10 == 1;
                l1Cur.val = val % 10;
                l1Cur = l1Cur.next;
            }
        }
        l1 = reverseList(l1);
        if (l1.val == 0)
            return l1.next;
        return l1;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, next, nHead = null;
        while (cur != null) {
            next = cur.next;
            cur.next = nHead;
            nHead = cur;
            cur = next;
        }
        return nHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(7);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(4);
//        ListNode node3 = new ListNode(3);

        ListNode head2 = new ListNode(8);
//        ListNode node4 = new ListNode(6);
//        ListNode node5 = new ListNode(4);
//        head1.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//
//        head2.next = node4;
//        node4.next = node5;

        addTwoNumbers(head2, head1);
    }
}
