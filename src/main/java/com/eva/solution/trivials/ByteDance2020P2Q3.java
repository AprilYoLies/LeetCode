package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-08
 * @Email g863821569@gmail.com
 */

// 智慧老人

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 7
 * -2 0 1 2 2 3 6
 * 2
 */
public class ByteDance2020P2Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int max = sc.nextInt();
        int c = 0;
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (nums[i] > max) break;
            sum += nums[i];
            for (int j = i + 1; j < n; j++) {
                sum += nums[j];
                if (sum >= max) break;
                for (int k = j + 1; k < n; k++) {
                    sum += nums[k];
                    if (sum >= max) {
                        sum -= nums[k];
                        break;
                    }
                    StringBuilder sb = new StringBuilder();
                    String str = sb.append(nums[i]).append(",").append(nums[j]).append(",").append(nums[k]).toString();
                    if (!set.contains(str)) {
                        set.add(str);
                        c++;
                    }
                    sum -= nums[k];
                }
            }
        }
        System.out.println(c);
    }
}
