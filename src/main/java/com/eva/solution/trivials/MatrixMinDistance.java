package com.eva.solution.trivials;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixMinDistance {
    public static int minPathLength1(int[][] grids, int tr, int tc) {
        final int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        final int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                grids[cr][cc] = 0; // 标记
                for (int[] d : direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grids[nr][nc] == 0) {
                        continue;
                    }
                    if (nr == tr && nc == tc) {
                        return pathLength;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }

    public static int minPathLength(int[][] grids, int tr, int tc) {
        if (grids[0][0] == 0) return -1;
        if (tr == 0 && tc == 0) return 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0));
        int distance = 0;

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = queue.poll();
                assert pair != null;
                if (upOk(grids, pair)) {
                    if (pair.key - 1 == tr && pair.value == tc)
                        return distance;
                    queue.offer(new Pair<>(pair.key - 1, pair.value));
                }
                if (downOk(grids, pair)) {
                    if (pair.key + 1 == tr && pair.value == tc)
                        return distance;
                    queue.offer(new Pair<>(pair.key + 1, pair.value));
                }
                if (leftOk(grids, pair)) {
                    if (pair.key == tr && pair.value - 1 == tc)
                        return distance;
                    queue.offer(new Pair<>(pair.key, pair.value - 1));
                }
                if (rightOk(grids, pair)) {
                    if (pair.key == tr && pair.value + 1 == tc)
                        return distance;
                    queue.offer(new Pair<>(pair.key, pair.value + 1));
                }
            }
        }
        return -1;
    }

    private static boolean rightOk(int[][] grids, Pair<Integer, Integer> pair) {
        return pair.value < grids[0].length - 1 && grids[pair.key][pair.value + 1] == 1;
    }

    private static boolean leftOk(int[][] grids, Pair<Integer, Integer> pair) {
        return pair.value > 0 && grids[pair.key][pair.value - 1] == 1;
    }

    private static boolean downOk(int[][] grids, Pair<Integer, Integer> pair) {
        return pair.key < grids.length - 1 && grids[pair.key + 1][pair.value] == 1;
    }

    private static boolean upOk(int[][] grids, Pair<Integer, Integer> pair) {
        return pair.key > 0 && grids[pair.key - 1][pair.value] == 1;
    }

    public static void main(String[] args) {
        System.out.println(minPathLength(new int[][]{{1, 1, 0, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}}, 0, 2));
        System.out.println(minPathLength1(new int[][]{{1, 1, 0, 1}, {1, 0, 1, 0}, {1, 1, 1, 1}, {1, 0, 1, 1}}, 0, 2));
    }

    private static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
