package com.eva.solution.sword2offer;

import java.util.ArrayList;

/**
 * @Author EvaJohnson
 * @Date 2019-08-01
 * @Email g863821569@gmail.com
 */
public class PrintMatrix {
    // 1 2 3
    // 4 5 6
    // 7 8 9

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int colLeft = 0;
        int colRight = matrix[0].length - 1;
        int rowTop = 0;
        int rowBottom = matrix.length - 1;
        while (colLeft <= colRight && rowTop <= rowBottom) {
            for (int i = colLeft; i <= colRight; i++) {
                res.add(matrix[rowTop][i]);
            }
            if (rowTop == rowBottom) {
                return res;
            }
            for (int i = rowTop + 1; i <= rowBottom; i++) {
                res.add(matrix[i][colRight]);
            }
            if (colLeft == colRight) {
                return res;
            }
            for (int i = colRight - 1; i >= colLeft; i--) {
                res.add(matrix[rowBottom][i]);
            }

            for (int i = rowBottom - 1; i > rowTop; i--) {
                res.add(matrix[i][colLeft]);
            }
            rowTop += 1;
            rowBottom -= 1;
            colLeft += 1;
            colRight -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4,5}};
        ArrayList<Integer> integers = new PrintMatrix().printMatrix(matrix);
        System.out.println(integers);
    }
}
