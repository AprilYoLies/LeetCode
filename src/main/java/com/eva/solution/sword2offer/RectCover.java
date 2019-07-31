package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class RectCover {
    public int jumpFloor(int target) {
        if (target < 3) {
            return target;
        }
        int[] res = new int[target + 1];
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i <= target; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[target];
    }

    public static void main(String[] args) {
        RectCover jumpFloor = new RectCover();
        int i = jumpFloor.jumpFloor(3);
        System.out.println(i);
    }
}
