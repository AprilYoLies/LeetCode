package com.eva.solution.sword2offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-02
 * @Email g863821569@gmail.com
 */
public class RandomListClone {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode head = cloneNext(pHead);
        cloneRandom(head, pHead);
        return head;
    }

    private void cloneRandom(RandomListNode head, RandomListNode pHead) {
        RandomListNode cur = pHead;
        RandomListNode pos = head;
        List<RandomListNode> accessed = new ArrayList<>();
        while (cur != null) {
            RandomListNode curRand = cur;
            RandomListNode posRand = pos;
            while (curRand.random != null && !accessed.contains(curRand.random)) {
                posRand.random = findByLabel(head, curRand.random.label);
                accessed.add(curRand.random);
                curRand = curRand.random;
                posRand = posRand.random;
            }
            cur = cur.next;
            pos = pos.next;
        }
    }

    private RandomListNode findByLabel(RandomListNode pos, int label) {
        RandomListNode cur = pos;
        while (cur != null) {
            if (cur.label == label)
                return cur;
            cur = cur.next;
        }
        return null;
    }

    public RandomListNode cloneNext(RandomListNode pHead) {
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode cur = pHead;
        RandomListNode pos = head;
        while (cur.next != null) {
            pos.next = new RandomListNode(cur.next.label);
            cur = cur.next;
            pos = pos.next;
        }
        return head;
    }

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = node3;
        node2.random = node5;
        node4.random = node2;
        RandomListClone listClone = new RandomListClone();
        listClone.Clone(node1);
    }
}
