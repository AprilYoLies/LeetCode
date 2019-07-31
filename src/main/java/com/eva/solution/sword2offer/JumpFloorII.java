package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class JumpFloorII {
    public int jumpFloorII(int target) {
        return (int) Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        JumpFloorII jumpFloor = new JumpFloorII();
        int i = jumpFloor.jumpFloorII(3);
        System.out.println(i);
    }
}
