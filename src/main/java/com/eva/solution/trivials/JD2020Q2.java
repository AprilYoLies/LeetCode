package com.eva.solution.trivials;

import java.util.*;

public class JD2020Q2 {
    /**
     * 2 2
     * 1 3
     * 1 4
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] rs = new int[n][n];
        for (int i = 0; i < m; i++) {
            rs[sc.nextInt() - 1][sc.nextInt() - n - 1] = 1;
        }
        List<Integer> list = new ArrayList<>();
        while (true) {
            int pos = -1;
            int max = 0;
            for (int i = 0; i < 2 * n; i++) {
                int len = 0;
                for (int j = 0; j < n; j++) {
                    if (i < n) {
                        if (rs[i][j] == 1) {
                            len++;
                        }
                    } else {
                        if (rs[j][i - n] == 1) {
                            len++;
                        }
                    }
                }
                if (len > max) {
                    max = len;
                    pos = i;
                }
            }
            if (pos == -1) {
                break;
            } else if (pos < n) {
                for (int i = 0; i < n; i++) {
                    rs[pos][i] = 0;
                }
            } else {
                for (int i = 0; i < n; i++) {
                    rs[i][pos - n] = 0;
                }
            }
            list.add(pos + 1);
        }
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        Collections.sort(list, Comparator.comparingInt(o -> o));
        for (Integer integer : list) {
            sb.append(integer + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
