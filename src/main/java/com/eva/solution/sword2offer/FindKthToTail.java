package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        int count = 1;
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            count++;
        }
        if (k > count)
            return null;
        node = head;
        for (int i = 0; i < count - k; i++) {
            node = node.next;
        }
        return node;
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}


