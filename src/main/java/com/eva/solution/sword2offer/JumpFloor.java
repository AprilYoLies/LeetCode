package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-07-31
 * @Email g863821569@gmail.com
 */
public class JumpFloor {
    public int jumpFloor(int target) {
        int[] steps = new int[target + 2];
        steps[1] = 1;
        steps[2] = 2;
        if( target > 0 && target < 3) {
            return steps[target];
        }
        for (int i = 3; i <= target; i++) {
            steps[i] = steps[i - 1] + steps[i - 2];
        }
        return steps[target];
    }

    public static void main(String[] args) {
        JumpFloor jumpFloor = new JumpFloor();
        int i = jumpFloor.jumpFloor(3);
        System.out.println(i);
    }
}
