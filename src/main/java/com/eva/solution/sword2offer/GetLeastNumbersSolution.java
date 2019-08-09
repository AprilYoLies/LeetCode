package com.eva.solution.sword2offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author EvaJohnson
 * @Date 2019-08-09
 * @Email g863821569@gmail.com
 */
public class GetLeastNumbersSolution {
    public static ArrayList<Integer> getLeastNumbersSolution(int[] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if (input.length < k)
            return list;
        Arrays.sort(input);
        if (k == 0)
            return list;
        if (k == 1) {
            list.add(input[0]);
            return list;
        }
        int pre = input[0];
        list.add(pre);
        for (int i = 1; i < input.length; i++) {
            if (input[i] != pre) {
                list.add(input[i]);
                if (list.size() == k)
                    return list;
            }
            pre = input[i];

        }
        list.clear();
        return list;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,1,6,2,7,3,8};
        getLeastNumbersSolution(array,10);
    }
}
