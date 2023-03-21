package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution19 {
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode cur = head;
        ListNode target = head;
        while (cur != null) {
            if (n >= 0) {
                n--;
            } else target = target.next;
            cur = cur.next;
        }
        if (n == 0) {
            head = head.next;
            return head;
        }
        target.next = target.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode cur = head, target = null, pre = null;
        int count = 1;
        if (count == n) {
            target = cur;
        }
        while (cur.next != null) {
            count++;
            if (count == n) {
                target = head;
            } else if (count > n) {
                pre = target;
                target = target.next;
            }
            cur = cur.next;
        }
        if (pre == null) return head.next;
        pre.next = pre.next.next;
        return head;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = head;
        ListNode target = null;
        ListNode cur = head;
        ListNode pre = null;
        int count = 1;
        if (count == n) {
            target = head;
        }
        while (cur != null) {
            cur = cur.next;
            if (cur == null) {
                break;
            }
            count++;
            if (count == n) {
                target = head;
            }
            if (count > n) {
                pre = target;
                target = target.next;
            }
        }
        if (pre != null && target != null) {
            pre.next = target.next;
        }
        if (newHead == target) {
            newHead = target.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
//        head.next = node1;
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        ListNode newList = removeNthFromEnd(head, 1);
        System.out.println(newList);
    }
}
