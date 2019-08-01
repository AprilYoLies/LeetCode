package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class ListMerge {
    // 1 2 3 4 5 6 7 8
    // 2 4 5 7 8 9
    public ListNode listMerge(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        ListNode head;

        if (ptr1.val > ptr2.val) {
            head = ptr2;
            ptr2 = ptr2.next;
        } else {
            head = ptr1;
            ptr1 = ptr1.next;
        }
        ListNode ptr3 = head;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val > ptr2.val) {
                ptr3.next = ptr2;
                ptr2 = ptr2.next;
                ptr3 = ptr3.next;
            } else {
                ptr3.next = ptr1;
                ptr1 = ptr1.next;
                ptr3 = ptr3.next;
            }
        }
        if (ptr1 == null)
            ptr3.next = ptr2;
        else
            ptr3.next = ptr1;
        return head;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
