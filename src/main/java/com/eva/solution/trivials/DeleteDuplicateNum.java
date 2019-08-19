package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-08-19
 * @Email g863821569@gmail.com
 */
public class DeleteDuplicateNum {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int a = 0, b = 0;
        while (b != nums.length - 1) {
            if (nums[b] != nums[++b]) {
                nums[++a] = nums[b];
            }
        }
        return a + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 3, 3}));
    }
}
