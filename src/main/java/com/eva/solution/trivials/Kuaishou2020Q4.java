package com.eva.solution.trivials;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-16
 * @Email g863821569@gmail.com
 */

/**
 * 4
 * 1 4 5 3
 */
public class Kuaishou2020Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int max = 1;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                int count = 2, sum = nums[i] + diff + diff;
                while (Arrays.binarySearch(nums, sum) >= 0) {
                    count++;
                    sum += diff;
                }
                if (count > max) max = count;
            }
        }
        System.out.println(max);
    }
}
