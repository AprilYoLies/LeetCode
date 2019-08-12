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
            if (isCycle(edges, edge, map)) {
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

    private static boolean isCycle(Edge[] edges, Edge edge, Map<Character, Character> nodes) {
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

    private static List<Edge> prim(Edge[] edges, char[] nodes) {
        List<Edge> res = new ArrayList<>(nodes.length - 1);
        List<Character> chars = new LinkedList<>();
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < nodes.length; i++) {
            chars.add(nodes[i]);
        }
        Map<Character, Character> map = new HashMap<>();
        Character character = chars.remove(0);
        while (character != null) {
            Edge edge = matchEdge(edges, character, visited, map);
            if (edge != null) {
                if (character == edge.from)
                    character = edge.to;
                else
                    character = edge.from;
                res.add(edge);
                chars.remove(character);
            } else if (chars.size() != 0)
                character = chars.remove(0);
            else
                character = null;
        }
        return res;
    }

    private static Edge matchEdge(Edge[] edges, Character character, boolean[] visited, Map<Character, Character> map) {
        List<Edge> candiEdges = candidateEdges(edges, character);
        candiEdges.sort(Comparator.comparingInt(o1 -> o1.weight));
        for (Edge candiEdge : candiEdges) {
            int i = Arrays.binarySearch(edges, candiEdge);
            if (!visited[i] && !isCycle(edges, candiEdge, map)) {
                visited[i] = true;
                return candiEdge;
            }
        }
        return null;
    }

    /**
     * 获取和参数 character 直接相连的全部边
     *
     * @param edges     连接边集合
     * @param character 目标节点
     * @return 和目标节点直接相连的边集合
     */
    private static List<Edge> candidateEdges(Edge[] edges, Character character) {
        List<Edge> candidates = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i].from == character || edges[i].to == character)
                candidates.add(edges[i]);
        }
        return candidates;
    }

    private static Stack<Character> stack = new Stack<>();

    /**
     * 深度优先遍历
     *
     * @param edges 节点的连接集合
     * @param nodes 节点集合
     * @param begin 初始节点
     * @return dfs 结果
     */
    private static String dfs(Edge[] edges, char[] nodes, char begin) {
        boolean[] visited = new boolean[nodes.length];
        int i = Arrays.binarySearch(nodes, begin);
        visited[i] = true;
        StringBuilder sb = new StringBuilder("dfs:");
        sb.append(begin);
        stack.push(begin);
        dfs(edges, nodes, visited, begin, sb, stack);
        return sb.toString();
    }

    /**
     * 递归处理深度优先遍历
     *
     * @param edges   节点的连接集合
     * @param nodes   节点集合
     * @param visited 已访问节点标志
     * @param cur     当前正在处理的节点
     * @param sb      拼接结果
     * @param stack   递归栈
     */
    private static void dfs(Edge[] edges, char[] nodes, boolean[] visited, char cur, StringBuilder sb, Stack<Character> stack) {
        Character next = findNext(edges, cur, visited, nodes);
        if (next == null) {
            if (stack.isEmpty())
                return;
            Character pre = stack.pop();
            dfs(edges, nodes, visited, pre, sb, stack);
            return;
        }
        sb.append(", ").append(next);
        stack.push(next);
        dfs(edges, nodes, visited, next, sb, stack);
    }

    /**
     * 查找当前节点下一个可访问节点
     *
     * @param edges   节点的连接集合
     * @param cur     当前节点
     * @param visited 节点访问标志
     * @param nodes   节点集合
     * @return 下一个有效节点
     */
    private static Character findNext(Edge[] edges, char cur, boolean[] visited, char[] nodes) {
        List<Edge> candidates = candidateEdges(edges, cur);
        for (Edge candidate : candidates) {
            char next;
            if (candidate.from == cur)
                next = candidate.to;
            else
                next = candidate.from;
            int i = Arrays.binarySearch(nodes, next);
            if (!visited[i]) {
                visited[i] = true;
                return next;
            }
        }
        return null;
    }

    /**
     * 广度优先遍历
     *
     * @param edges 节点的连接集合
     * @param nodes 节点集合
     * @param c     起始节点
     * @return 广度优先遍历结果
     */
    private static String bfs(Edge[] edges, char[] nodes, char c) {
        StringBuilder sb = new StringBuilder("bfs:");
        List<Character> chars = new ArrayList<>();
        chars.add(c);
        boolean[] visited = new boolean[nodes.length];
        bfs(chars, sb, edges, nodes, visited);
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /**
     * 递归广度优先遍历
     *
     * @param chars   当前层节点结合
     * @param sb      StringBuilder
     * @param edges   节点的连接集合
     * @param nodes   节点集合
     * @param visited 节点的访问标志
     */
    private static void bfs(List<Character> chars, StringBuilder sb, Edge[] edges, char[] nodes, boolean[] visited) {
        List<Character> nChars = new ArrayList<>();
        if (chars.size() == 0)
            return;
        for (Character c : chars) {
            sb.append(c).append(", ");
            visited[Arrays.binarySearch(nodes, c)] = true;
            List<Edge> candidates = candidateEdges(edges, c);
            for (Edge candidate : candidates) {
                char next;
                if (candidate.from == c)
                    next = candidate.to;
                else
                    next = candidate.from;
                int i = Arrays.binarySearch(nodes, next);
                if (!visited[i]) {
                    visited[i] = true;
                    nChars.add(next);
                }
            }
        }
        bfs(nChars, sb, edges, nodes, visited);
    }

    /**
     * 节点连接权重信息
     */
    private static class Edge implements Comparable {
        char from;
        char to;
        int weight;

        Edge(char from, char to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Edge edge = (Edge) o;
            return this.weight - edge.weight;
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

        res = prim(edges, nodes);
        sb = new StringBuilder("prim: ");
        for (Edge re : res) {
            sb.append("[ ").append(re.from).append(", ").append(re.to).append(" ] ");
        }
        System.out.println(sb.toString());

        String dfs = dfs(edges, nodes, 'B');
        System.out.println(dfs);

        String bfs = bfs(edges, nodes, 'A');
        System.out.println(bfs);
    }

}
