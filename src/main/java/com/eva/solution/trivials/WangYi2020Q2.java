package com.eva.solution.trivials;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author EvaJohnson
 * @Date 2019-09-20
 * @Email g863821569@gmail.com
 */
public class WangYi2020Q2 {

    public void removeDuplicates(ListNode head) {
        ListNode cur = head.next, tail = head;
        Map<Integer, Integer> map = new HashMap<>();
        pubEleToMap(head, map);
        while (cur != null) {
            if (pubEleToMap(cur, map)) {
                tail.next = cur;
                cur = cur.next;
                tail = tail.next;
                tail.next = null;
            } else {
                cur = cur.next;
            }
        }
    }

    private boolean pubEleToMap(ListNode node, Map<Integer, Integer> map) {
        if (map.get(node.val) == null) {
            map.put(node.val, 1);
            return true;
        } else if (map.get(node.val) == 1) {
            map.put(node.val, 2);
            return true;
        } else
            return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
