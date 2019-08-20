package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-20
 * @Email g863821569@gmail.com
 */
public class Solution206 {
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

    private static ListNode pHead;

    public static ListNode reverseList1(ListNode head) {
        if (head == null)
            return pHead;
        doReverseList(head);
        return pHead;
    }

    public static ListNode doReverseList(ListNode head) {
        if (head.next == null) {
            pHead = head;
            return head;
        }
        doReverseList(head.next).next = head;
        head.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        ListNode pHead = reverseList(head);
        ListNode nHead1 = reverseList1(head);
//        System.out.println(pHead);
//        System.out.println(nHead1);
    }
}
