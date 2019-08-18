package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-08-18
 * @Email g863821569@gmail.com
 */

public class ListSplit {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public static ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null)
            return null;
        ListNode ahead = null;
        ListNode aheadPos = null;
        ListNode behind = null;
        ListNode behindPos = null;
        ListNode target = null;
        ListNode targetPos = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode pre = cur;
            if (cur.val < x) {
                if (ahead == null) {
                    ahead = pre;
                    aheadPos = ahead;
                } else {
                    aheadPos.next = pre;
                    aheadPos = aheadPos.next;
                }
            } else if (pre.val > x) {
                if (behind == null) {
                    behind = pre;
                    behindPos = pre;
                } else {
                    behindPos.next = pre;
                    behindPos = behindPos.next;
                }
            } else {
                if (target == null) {
                    target = pre;
                    targetPos = target;
                } else {
                    targetPos.next = pre;
                    targetPos = targetPos.next;
                }
            }
            cur = cur.next;
            pre.next = null;
        }
        if (aheadPos == null)
            ahead = target;
        else
            aheadPos.next = target;
        if (target == null)
            if (aheadPos == null)
                ahead = behind;
            else
                aheadPos.next = behind;
        else
            targetPos.next = behind;
        return ahead;
    }

    /**
     * @param head: The first node of linked list
     * @param x:    An integer
     * @return: A ListNode
     */
    public static ListNode partition1(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode ahead = null;
        ListNode aheadPos = null;
        ListNode cur = head;
        ListNode pre = null;
        ListNode behind = null;
        while (cur != null) {
            ListNode pos = cur;
            if (cur.val < x) {
                if (ahead == null) {
                    ahead = pos;
                    aheadPos = ahead;
                } else {
                    aheadPos.next = pos;
                    aheadPos = aheadPos.next;
                }

                cur = cur.next;
                pos.next = null;

                if (pre != null)
                    pre.next = cur;

                continue;
            }
            pre = pos;
            cur = cur.next;
            if (behind == null)
                behind = pos;
        }
        if (ahead == null)
            return head;
        aheadPos.next = behind;
        return ahead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;
        partition1(node1, 3);
    }
}