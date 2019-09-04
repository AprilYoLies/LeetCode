package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-04
 * @Email g863821569@gmail.com
 */

import java.util.Scanner;

public class Xiecheng2020Q1 {

    /*请完成下面这个函数，实现题目要求的功能
     ******************************开始写代码******************************/
    static ListNode partition(ListNode head, int m) {
        ListNode cur = head, nHead = null, tHead = null, nTail = null, pre = null;
        while (cur != null) {
            if (cur.val <= m) {
                if (nHead == null) {
                    nHead = cur;
                    nTail = nHead;
                } else {
                    nTail.next = cur;
                    nTail = nTail.next;
                }
                if (pre != null)
                    pre.next = nTail.next;
                cur = cur.next;
                nTail.next = null;
            } else {
                if (tHead == null) {
                    tHead = cur;
                    pre = cur;
                } else {
                    pre = cur;
                }
                cur = cur.next;
            }
        }
        if (nTail != null)
            nTail.next = tHead;
        else
            return tHead;
        return nHead;
    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        while (in.hasNextInt()) {
            int v = in.nextInt();
            if (head == null) {
                node = new ListNode(v);
                head = node;
            } else {
                node.next = new ListNode(v);
                node = node.next;
            }
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
