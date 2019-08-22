package com.eva.solution.leetcode;

import java.util.*;

public class Solution127 {
    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int N = wordList.size();
        int start = N - 1;
        int end = 0;
        while (end < N && !wordList.get(end).equals(endWord)) {
            end++;
        }
        if (end == N) {
            return 0;
        }
        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private static List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for (int i = 0; i < N; i++) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    private static boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    private static int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[graphic.length];
        queue.add(start);
        marked[start] = true;
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    if (next == end) {
                        return path;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord) || beginWord.length() != endWord.length()) return 0;
        wordList.add(0, beginWord);
        wordList.add(endWord);
        Map<String, List<String>> map = getWordsMap(wordList);
        boolean[] visited = new boolean[wordList.size()];
        visited[0] = true;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int distance = 0;

        while (!queue.isEmpty()) {
            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String from = queue.poll();
                if (endWord.equals(from)) return distance;
                List<String> tos = map.get(from);
                for (String to : tos) {
                    if (visited[wordList.indexOf(to)]) continue;
                    visited[wordList.indexOf(to)] = true;
                    queue.offer(to);
                }
            }
        }
        return 0;
    }

    private static Map<String, List<String>> getWordsMap(List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>(wordList.size());
        for (String word : wordList) {
            List<String> words = new ArrayList<>();
            for (String str : wordList) {
                int c = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (word.charAt(i) != str.charAt(i)) {
                        if (c++ == 1) break;
                    }
                }
                if (c == 1)
                    words.add(str);
            }
            map.put(word, words);
        }
        return map;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        System.out.println(ladderLength1("hit", "cog", words));
        System.out.println(ladderLength("hit", "cog", words));
    }
}
