package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode ptr = head;
        ListNode pre = null;
        while (ptr.next != null) {
            ListNode next = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = next;
        }
        ptr.next = pre;
        return ptr;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
