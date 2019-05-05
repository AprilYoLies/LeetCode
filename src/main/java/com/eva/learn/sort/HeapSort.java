package com.eva.learn.sort;

/**
 * @Author EvaJohnson
 * @Date 2019-05-04
 * @Email g863821569@gmail.com
 */
public class HeapSort {
    private static int[] heapSort(int[] a) {
        int[] maxHeap = arrToMaxHeap(a);
        return sortHeap(maxHeap);
    }

    /**
     * 根据最大堆，对数据进行排序
     *
     * @param maxHeap 最大堆
     * @return 排序结果
     */
    private static int[] sortHeap(int[] maxHeap) {
        int len = maxHeap.length;
        for (int i = 0; i < len - 1; i++) {
            int tail = len - 1 - i;
            // 将未排序序列的首尾元素进行对调
            int t = maxHeap[0];
            maxHeap[0] = maxHeap[tail];
            maxHeap[tail] = t;
            // 重构最大堆
            int p = 0;
            int s;
            // 调整首节点，因为上述对调操作后，0 - tail 区间中的数据已经不满足最大堆性质了，需要进行调换来重构最大堆
            // 首先需要判断当前节点是否有孩子节点，上界为 ceil，ceil 及以后的序列是已经排好序的。
            // 如果当前节点的两个孩子节点其中之一大于当前节点，则进行其中较大的那个节点进行交换，然后将当前节点设置为目标叶子节点。
            // 重复上述过程
            while ((s = 2 * p + 1) < tail && (maxHeap[p] < maxHeap[s] || maxHeap[p] < maxHeap[s + 1])) {
                // 如果右节点大于左节点，并且右节点没有超过上界 tail 则当前节点和右节点交换
                if (maxHeap[s] < maxHeap[s + 1] && s + 1 < tail) {
                    t = maxHeap[p];
                    maxHeap[p] = maxHeap[s + 1];
                    maxHeap[s + 1] = t;
                    p = s + 1;
                    continue;
                }
                // 到这里说明不能跟右孩子交换，则判断是否左孩子满足交换条件
                else if (maxHeap[p] < maxHeap[s]) {
                    t = maxHeap[p];
                    maxHeap[p] = maxHeap[s];
                    maxHeap[s] = t;
                    p = s;
                    continue;
                }
                break;
            }
        }
        return maxHeap;
    }

    /**
     * 将数组转换为最大堆
     *
     * @param a 原数组
     * @return 得到的最大堆
     */
    private static int[] arrToMaxHeap(int[] a) {
        int len = a.length;
        int[] maxHeap = new int[len];
        for (int i = 0; i < len; i++) {
            maxHeap[i] = a[i];
            int s = i;
            int p;
            // 对加入的数据按规则进行调整
            while ((p = (int) Math.floor((s - 1) * 1.0 / 2)) >= 0 && maxHeap[s] > maxHeap[p]) {
                int t = maxHeap[s];
                maxHeap[s] = maxHeap[p];
                maxHeap[p] = t;
                s = p;
            }

        }
        return maxHeap;
    }

    public static void main(String[] args) {
        int i;
        int[] a = {30, 40, 60, 10, 20, 50, 70, 25, 33, 12, 90, 100, 87, 59, 39, 101};

        System.out.print("before sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");

        a = heapSort(a);

        System.out.print("after  sort:");
        for (i = 0; i < a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.print("\n");
    }
}
