package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Author EvaJohnson
 * @Date 2019-09-19
 * @Email g863821569@gmail.com
 */

/**
 * 4 5
 * 3 0
 * 0 4
 * 4
 * 1 0
 * 1 1
 * 1 2
 * 2 4
 */
public class Hua2020MQ2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   // 行
        int n = sc.nextInt();   // 列
        int si = sc.nextInt();  // 起点横坐标
        int sj = sc.nextInt();  // 起点纵坐标
        int ei = sc.nextInt();  // 终点横坐标
        int ej = sc.nextInt();  // 终点纵坐标
        int[][] map = new int[m][n];
        int q = sc.nextInt();   // 墙的个数
        for (int i = 0; i < q; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = 1;  // 将墙的位置标记为 1
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ei, ej}); // ei 和 ej 是终点的横纵坐标
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {    // 广度优先搜索
                int[] pos = queue.poll();
                assert pos != null;
                map[pos[0]][pos[1]] = 2;    // 能到达的点标记为 2（地图的墙为 1，默认为 0）
                int li = pos[0], lj = pos[1] - 1, bi = pos[0] + 1, bj = pos[1]; // li 和 lj 为左边节点的横纵坐标，bi 和 bj 为下边节点的横纵坐标
                if (lj >= 0 && lj < n && map[li][lj] != 1) queue.offer(new int[]{li, lj});  // 从终点广度优先搜索，等价于只能向左或者向下走
                if (bi >= 0 && bi < m && map[bi][bj] != 1) queue.offer(new int[]{bi, bj});
            }
        }
        int bc = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) bc++;   // 统计地图中没有被标记的点，结果就是陷阱（bc）的数量
            }
        }
        queue.offer(new int[]{si, sj}); // si 和 sj 是起点的横纵坐标
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {    // 从起点进行广度优先遍历
                int[] pos = queue.poll();
                assert pos != null;
                map[pos[0]][pos[1]] = 3;    // 因为上边的遍历标记为 2，这里为了区分标记为 3
                int ri = pos[0], rj = pos[1] + 1, ui = pos[0] - 1, uj = pos[1]; // ri 和 rj 为右边节点的横纵坐标，ui 和 uj 为上边节点的横纵坐标
                if (rj >= 0 && rj < n && map[ri][rj] != 1) queue.offer(new int[]{ri, rj});  // 从终点广度优先搜索，等价于只能向右或者向上走
                if (ui >= 0 && ui < m && map[ui][uj] != 1) queue.offer(new int[]{ui, uj});
            }
        }
        int ac = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 1 && map[i][j] != 3) ac++; // 这里进行统计，如果不是墙并且也不是被标记为 3 的节点，那么就是不可达点
            }
        }
        System.out.println(ac + " " + bc);
    }
}
