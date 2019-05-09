package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
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
}
