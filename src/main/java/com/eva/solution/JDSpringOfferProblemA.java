package com.eva.solution;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-04-13
 * @Email g863821569@gmail.com
 */
public class JDSpringOfferProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 保存座位的访问情况
        Map<Integer, Boolean> visited = new HashMap<>();
        // 保存座位号之间的路径关系
        Map<Integer, LinkedList<Integer>> edge = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            visited.putIfAbsent(a, false);
            visited.putIfAbsent(b, false);
            putEdge(a, b, edge);
            putEdge(b, a, edge);
        }

        int count = 0;
        LinkedList<Integer> integers = edge.get(1);
        visited.put(1, true);
        for (Integer poi : integers) {
            visited.put(poi, true);
            int s = track(poi, edge, visited);
            if (s > count) {
                count = s;
            }
        }
        System.out.println(count + 1);
    }

    /**
     * @param poi     当前座位号
     * @param edge    路径关系
     * @param visited 保存已访问的座位号
     * @return poi 和poi连同的所有下游座位节点的总数
     */
    private static int track(int poi, Map<Integer, LinkedList<Integer>> edge, Map<Integer, Boolean> visited) {
        int count = 0;
        LinkedList<Integer> list = edge.get(poi);
        if (list == null) return count;
        for (Integer i : list) {
            if (visited.get(i)) continue;
            visited.put(i, true);
            count++;
            count += track(i, edge, visited);
        }
        return count;
    }

    /**
     * 填充路径关系
     *
     * @param a
     * @param b
     * @param edge
     */
    private static void putEdge(int a, int b, Map<Integer, LinkedList<Integer>> edge) {
        if (edge.get(a) == null) {
            LinkedList<Integer> integers = new LinkedList<>();
            edge.put(a, integers);
        }
        edge.get(a).add(b);
    }
}
