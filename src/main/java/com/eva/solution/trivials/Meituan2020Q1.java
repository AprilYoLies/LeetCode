package com.eva.solution.trivials;

import java.util.*;

public class Meituan2020Q1 {
    // MPMPCPMCMDEFEGDEHINHKLIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            int[] fromTo = map.get(line.charAt(i));
            if (fromTo == null) {
                map.put(line.charAt(i), new int[]{i, -1});
            } else {
                fromTo[1] = i;
            }
        }
        List<int[]> fromTos = new ArrayList<>(map.values());
        fromTos.sort(Comparator.comparingInt(o -> o[0]));
        int[] pre = fromTos.get(0);
        List<Integer> tmp = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < fromTos.size(); i++) {
            if (fromTos.get(i)[0] > pre[1]) {
                tmp.add(fromTos.get(i)[0]);
                pre = fromTos.get(i);
            } else {
                if (fromTos.get(i)[1] > pre[1])
                    pre = fromTos.get(i);
            }
        }
        tmp.add(line.length());
        res.add(tmp.get(0));
        for (int i = 1; i < tmp.size(); i++) {
            res.add(tmp.get(i) - tmp.get(i - 1));
        }
        System.out.println(res);
    }
}
