package com.eva.solution.leetcode;

public class Solution768 {
    public static int maxChunksToSorted(int[] arr) {
        if (arr.length == 0) return 0;
        int[] mins = new int[arr.length];
        mins[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            mins[i] = Math.min(arr[i], mins[i + 1]);
        }
        int count = 1;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (pre > mins[i]) {
                if (arr[i] > pre) pre = arr[i];
            } else {
                count++;
                pre = arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[]{}));
    }
}
