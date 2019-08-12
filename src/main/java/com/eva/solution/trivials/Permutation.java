package com.eva.solution.trivials;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author EvaJohnson
 * @Date 2019-08-12
 * @Email g863821569@gmail.com
 */
public class Permutation {
    public static Set<String> permutation(String str) {
        Set<String> res = new HashSet<>();
        char[] charArray = str.toCharArray();
        boolean[] visited = new boolean[charArray.length];
        StringBuilder sb = new StringBuilder();
        permutation(charArray, visited, res, sb);
        return res;
    }

    private static void permutation(char[] charArray, boolean[] visited, Set<String> res, StringBuilder sb) {
        if (sb.length() == charArray.length) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < charArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                sb.append(charArray[i]);
                permutation(charArray, visited, res, sb);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        permutation("abcdefghi");
    }
}
