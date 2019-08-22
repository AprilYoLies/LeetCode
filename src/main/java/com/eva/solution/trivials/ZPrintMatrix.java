package com.eva.solution.trivials;

public class ZPrintMatrix {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public static int[] printZMatrix(int[][] matrix) {
        // write your code here
        int r = matrix.length, c = matrix[0].length, i = 0, j = 0, count = 0, len = r * c;
        boolean flag = true;
        int[] results = new int[len];
        while (count != len) {
            results[count++] = matrix[i][j];
            if (flag) {
                if (i > 0 && j < c - 1) {
                    i--;
                    j++;
                } else {
                    if (i == 0 && j < c - 1) j++;
                    else if (i > 0 && j == c - 1) i++;
                    else i++;
                    flag = !flag;
                }
            } else {
                if (i < r - 1 && j > 0) {
                    i++;
                    j--;
                } else {
                    if (i == r - 1 && j > 0) j++;
                    else if (i < r - 1 && j == 0) i++;
                    else j++;
                    flag = !flag;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        printZMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
    }
}
