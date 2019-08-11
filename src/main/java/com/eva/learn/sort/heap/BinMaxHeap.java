package com.eva.learn.sort.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author EvaJohnson
 * @Date 2019-08-11
 * @Email g863821569@gmail.com
 */
public class BinMaxHeap {
    List<Integer> list = new ArrayList<>();

    public void insert(int n) {
        list.add(n);
        fixUpInsert(list.size() - 1);
    }

    public void remove(int n) {
        int i = list.indexOf(n);
        list.set(i, list.remove(list.size() - 1));
        fixUpRemove(i);
    }

    /**
     * 移除元素后维护最大堆的特性
     *
     * @param i 纠正节点
     */
    private void fixUpRemove(int i) {
        if (i >= list.size())
            return;
        if (i == list.size() - 1) {
            list.remove(i);
            return;
        }
        int il = 2 * i + 1;
        int ir = 2 * i + 2;
        int s;
        if (ir >= list.size())
            s = il;
        else {
            if (il >= list.size())
                return;
            s = list.get(il) > list.get(ir) ? il : ir;
        }
        if (s >= list.size())
            return;
        if (list.get(i) < list.get(s)) {
            int t = list.get(i);
            list.set(i, list.get(s));
            list.set(s, t);
        } else {
            return;
        }
        fixUpRemove(s);
    }

    /**
     * 插入元素后维护最大堆的特性
     *
     * @param i 纠正节点
     */
    private void fixUpInsert(int i) {
        if (i == 0)
            return;
        int pi = (i - 1) / 2;
        if (list.get(pi) < list.get(i)) {
            int t = list.get(pi);
            list.set(pi, list.get(i));
            list.set(i, t);
        } else {
            return;
        }
        fixUpInsert(pi);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i) + " ");

        return sb.toString();
    }

    public static void main(String[] args) {
        int i;
        int a[] = {20, 30, 90, 40, 70, 110, 60, 10, 100, 50, 80};
        BinMaxHeap heap = new BinMaxHeap();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < a.length; i++) {
            System.out.printf("%d ", a[i]);
            heap.insert(a[i]);
        }

        System.out.printf("\n== 最 大 堆: %s", heap);

        i = 85;
        heap.insert(i);
        System.out.printf("\n== 添加元素: %d", i);
        System.out.printf("\n== 最 大 堆: %s", heap);

        i = 90;
        heap.remove(i);
        System.out.printf("\n== 删除元素: %d", i);
        System.out.printf("\n== 最 大 堆: %s", heap);
        System.out.printf("\n");
    }
}
