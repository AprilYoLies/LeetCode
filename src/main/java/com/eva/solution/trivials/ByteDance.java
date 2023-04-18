package com.eva.solution.trivials;

import com.eva.solution.leetcode.ListNode;
import org.junit.Test;

public class ByteDance {

    @Test
    public void testSolution() {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(1);
        list1.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        list2.next = node2;
        // list1 ->    1 2 3 4 5
        // list2 ->        3 4 5
        System.out.println(findNode(list1, list2).val);
    }

    public ListNode findNode(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        while (true) {
            if (cur1 == cur2) return cur1;
            cur1 = cur1.next;
            if (cur1 == null) cur1 = list2;
            cur2 = cur2.next;
            if (cur2 == null) cur2 = list1;
        }
    }
}
