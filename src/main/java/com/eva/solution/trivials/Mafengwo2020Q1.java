package com.eva.solution.trivials;

import java.util.*;

/**
 * @Author EvaJohnson
 * @Date 2019-09-23
 * @Email g863821569@gmail.com
 */

/**
 * 34839946-beijing 34839946-shanghai 42342124-hongkong 42342124-guilin 42342124-guilin 12312344-shanghai 12312344-shanghai 22341234-nanjing
 */
public class Mafengwo2020Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] infos = sc.nextLine().split(" ");
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<String>> visited = new HashMap<>();
        for (String info : infos) {
            String[] noAddress = info.split("-");
            List<String> adds = visited.get(noAddress[0]);
            boolean flag = false;
            if (adds == null) {
                adds = new ArrayList<>();
                adds.add(noAddress[1]);
                visited.put(noAddress[0], adds);
                flag = true;
            } else {
                if (!adds.contains(noAddress[1])) {
                    adds.add(noAddress[1]);
                    flag = true;
                }
            }
            if (flag) {
                count.merge(noAddress[1], 1, Integer::sum);
            }
        }
        String[][] arr = new String[count.size()][2];
        int i = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            arr[i][0] = entry.getKey();
            arr[i][1] = entry.getValue() + "";
            i++;
        }
        Arrays.sort(arr, (o1, o2) -> {
            int c1 = Integer.parseInt(o1[1]);
            int c2 = Integer.parseInt(o2[1]);
            if (c1 == c2) {
                for (int k = 0; k < Math.min(o1[0].length(), o2[0].length()); k++) {
                    if (o1[0].charAt(k) == o2[0].charAt(k)) continue;
                    return o1[0].charAt(k) - o2[0].charAt(k);
                }
                return o1[0].length() - o2[0].length();
            }
            return -(c1 - c2);
        });
        i = 0;
        for (String[] addCount : arr) {
            if (++i >= 4) break;
            System.out.println(addCount[0] + " " + addCount[1]);
        }
    }
}
