package com.eva.learn.graph.kruskalprim;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-08-12
 * @Email g863821569@gmail.com
 */
public class MyUDG {

    private static List<Edge> kruskal(Edge[] edges, char[] nodes) {
        List<Edge> res = new ArrayList<>(nodes.length - 1);
        List<Edge> sorted = Arrays.asList(edges);
        sorted.sort(Comparator.comparingInt(o -> o.weight));
        int count = 0;
        Map<Character, Character> map = new HashMap<>();
        for (Edge edge : sorted) {
            if (isCycle(edge, map)) {
            } else {
                if (count++ < nodes.length - 1) {
                    res.add(edge);
                } else {
                    return res;
                }
            }
        }
        return res;
    }

    private static boolean isCycle(Edge edge, Map<Character, Character> nodes) {
        char from = edge.from;
        char to = edge.to;
        char fromEnd = getEnd(from, nodes);
        char toEnd = getEnd(to, nodes);
        if (fromEnd == toEnd)
            return true;
        nodes.put(fromEnd, toEnd);
        return false;
    }

    private static char getEnd(char from, Map<Character, Character> nodes) {
        Character end = from;
        while (nodes.get(end) != null) {
            end = nodes.get(end);
        }
        return end;
    }

    /**
     * 节点连接权重信息
     */
    private static class Edge {
        char from;
        char to;
        int weight;

        Edge(char from, char to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        char[] nodes = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Edge[] edges = {
                // 起点 终点 权
                new Edge('A', 'B', 12), new Edge('A', 'F', 16), new Edge('A', 'G', 14), new Edge('B', 'C', 10),
                new Edge('F', 'B', 7), new Edge('C', 'D', 3), new Edge('C', 'E', 5), new Edge('C', 'F', 6),
                new Edge('D', 'E', 4), new Edge('E', 'F', 2), new Edge('E', 'G', 8), new Edge('F', 'G', 9),};
        List<Edge> res = kruskal(edges, nodes);
        StringBuilder sb = new StringBuilder("kruskal: ");
        for (Edge re : res) {
            sb.append("[ ").append(re.from).append(", ").append(re.to).append(" ] ");
        }
        System.out.println(sb.toString());
    }
}
