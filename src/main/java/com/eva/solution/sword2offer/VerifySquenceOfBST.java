package com.eva.solution.sword2offer;

/**
 * @Author EvaJohnson
 * @Date 2019-08-02
 * @Email g863821569@gmail.com
 */
public class VerifySquenceOfBST {
    // 1 4
    public boolean verifySquenceOfvBST(int[] sequence) {
        int pos = sequence.length - 1;
        if (pos < 0) return false;
        return verify(sequence, pos, 0, pos - 1);
    }

    private boolean verify(int[] sequence, int pos, int l, int r) {
        if (l >= r)
            return true;
        boolean flag = true;
        int lPos = 0;
        for (int i = l; i <= r; i++) {
            if (flag && sequence[i] < sequence[pos]) {
                lPos = i;
                continue;
            }
            flag = false;
            if (sequence[i] > sequence[pos]) {
                continue;
            }
            return false;
        }
        return verify(sequence, lPos, l, lPos - 1) && verify(sequence, pos - 1, lPos + 1, pos - 2);
    }

    public static void main(String[] args) {
        int[] nums = {};
        VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        boolean b = verifySquenceOfBST.verifySquenceOfvBST(nums);
        System.out.println(b);
    }

}
