package com.eva.solution.sword2offer;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-08-05
 * @Email g863821569@gmail.com
 */
public class Permutation {
    public ArrayList<String> permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || "".equals(str))
            return list;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        Set<String> strs = new HashSet<>();
        boolean[] used = new boolean[chars.length];
        appendChar(chars, used, strs, new StringBuilder());
        list.addAll(strs);
        list.sort((o1, o2) -> {
            for (int i = 0; i < o1.length(); i++) {
                if (!(o1.charAt(i) == o2.charAt(i)))
                    return o1.charAt(i) - o2.charAt(i);
            }
            return 0;
        });
        return list;
    }

    private void appendChar(char[] chars, boolean[] used, Set<String> strs, StringBuilder sb) {
        if (sb.length() == used.length) {
            strs.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (!used[i]) {
                sb.append(chars[i]);
                used[i] = true;
                appendChar(chars, used, strs, sb);
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.permutation("abcdefghi");
    }
}
