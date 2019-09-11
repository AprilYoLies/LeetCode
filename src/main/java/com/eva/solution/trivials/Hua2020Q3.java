package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-09-11
 * @Email g863821569@gmail.com
 */

/**
 * 4
 * CZ7132,A1,ZHANGSAN
 * CZ7132,A2,ZHAOSI
 * CZ7156,A2,WANGWU
 * CZ3478,A3,LISI
 * 2
 * CZ7132,A1,CZ7156,A2
 * CZ7156,A2,CZ7156,A3
 */
public class Hua2020Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<String> before = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            before.add(sc.nextLine());
        }
        int m = Integer.parseInt(sc.nextLine());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine();
            int c = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == ',') {
                    c++;
                    if (c == 2) {
                        String key = str.substring(0, j);
                        String val = str.substring(j + 1);
                        map.put(key, val);
                        break;
                    }
                }
            }
        }
        List<String> after = new LinkedList<>();
        List<String> toRemove = new LinkedList<>();
        for (String bef : before) {
            StringBuilder sb = new StringBuilder();
            for (String key : map.keySet()) {
                if (bef.startsWith(key)) {
                    String seat = map.get(key);
                    sb.append(seat).append(bef.substring(key.length()));
                    String cancel = "";
                    for (String s : toRemove) {
                        if (s.startsWith(seat)) {
                            cancel = s;
                            break;
                        }
                    }
                    toRemove.remove(cancel);
                    String[] hs = seat.split(",");
                    String[] hsp = bef.split(",");
                    for (String s : before) {
                        if (s.startsWith(seat) || (s.startsWith(hs[0]) && s.endsWith(hsp[2]))) {
                            toRemove.add(s);
                        }
                    }
                    break;
                }
            }
            if (sb.length() > 0) {
                after.add(sb.toString());
            } else {
                after.add(bef);
            }
        }
        for (String s : toRemove) {
            after.remove(s);
        }
        Collections.sort(after, (o1, o2) -> {
            String[] o1s = o1.split(",");
            String[] o2s = o2.split(",");
            int hb1 = Integer.parseInt(o1s[0].substring(2));
            int hb2 = Integer.parseInt(o2s[0].substring(2));
            int seat1 = Integer.parseInt(o1s[1].substring(1));
            int seat2 = Integer.parseInt(o2s[1].substring(1));
            return hb1 - hb2 == 0 ? seat1 - seat2 : hb1 - hb2;
        });
        for (String s : after) {
            System.out.println(s);
        }
    }
}
