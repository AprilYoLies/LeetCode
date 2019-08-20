package com.eva.solution.leetcode;

/**
 * @Author EvaJohnson
 * @Date 2019-08-20
 * @Email g863821569@gmail.com
 */
public class Solution160 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode aCur = headA, bCur = headB;
        while (aCur != null) {
            while (bCur != null) {
                if (aCur == bCur)
                    return aCur;
                bCur = bCur.next;
            }
            bCur = headB;
            aCur = aCur.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode aCur = headA, bCur = headB;
        while (true) {
            if (aCur == bCur) return aCur;
            aCur = aCur.next;
            bCur = bCur.next;
            if (aCur == bCur) return aCur;
            if (aCur == null)
                aCur = headB;
            if (bCur == null)
                bCur = headA;
        }
    }
}
