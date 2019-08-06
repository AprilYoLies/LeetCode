package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-08-06
 * @Email g863821569@gmail.com
 */
public class PowerOfTwo {
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

    public static int numberOf1(int n) {
        int a = 0x01;
        int count = 0;
        for (int i = 0; i < 31; i++) {
            int b = (n >> i) & a;
            if (b != 0) {
                count++;
            }
        }
        if (n < 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        PowerOfTwo pot = new PowerOfTwo();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> numStrs = pot.permutation(s);
        for (int i = 0; i < numStrs.size(); i++) {
            int num = Integer.parseInt(numStrs.get(i));
            int c = numberOf1(num);
            if (c == 1) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }
}
