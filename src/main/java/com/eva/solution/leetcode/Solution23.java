package com.eva.solution.leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode cur;
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < lists.length; i++) {
            cur = lists[i];
            while (cur != null) {
                list.add(cur.val);
                cur = cur.next;
            }
        }
        list.sort(Comparator.comparingInt(o -> o));
        Iterator<Integer> iter = list.iterator();
        if (!iter.hasNext())
            return null;
        Integer h = iter.next();
        head = new ListNode(h);
        cur = head;
        while (iter.hasNext()) {
            cur.next = new ListNode(iter.next());
            cur = cur.next;
        }
        return head;
    }
}
