package com.eva.solution.trivials;

/**
 * @Author EvaJohnson
 * @Date 2019-09-13
 * @Email g863821569@gmail.com
 */

import java.util.*;

/**
 * 2
 * 134503 834703
 * 834703 134503
 * 134503  834503 834703，共2步。
 */
public class TuSen2020Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cards = new int[n][2];
        Set<String> primes = getPrimeNumberToN(999999);
        for (int i = 0; i < n; i++) {
            cards[i][0] = sc.nextInt();
            cards[i][1] = sc.nextInt();
        }
        for (int[] card : cards) {
            Set<String> visited = new HashSet<>();
            String before = numToString(card[0]);
            String aft = numToString(card[1]);
            Queue<String> queue = new LinkedList<>();
            queue.add(before);
            int count = 0;
            boolean find = false;
            loop:
            while (!queue.isEmpty()) {
                count++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    before = queue.poll();
                    visited.add(before);
                    assert before != null;
                    for (int j = 0; j < before.length(); j++) {
                        StringBuilder sb = new StringBuilder();
                        char c = before.charAt(j);
                        sb.append(before, 0, j);
                        for (int k = '0'; k <= '9'; k++) {
                            if (k != c) {
                                sb.append((char) k);
                                sb.append(before.substring(j + 1));
                                String after = sb.toString();
                                if (!visited.contains(after) && primes.contains(after)) {
                                    if (aft.equals(after)) {
                                        find = true;
                                        break loop;
                                    }
                                    queue.offer(after);
                                }
                                sb.delete(j, sb.length());
                            }
                        }
                    }
                }
            }
            if (find) System.out.println(count);
            else System.out.println(-1);
        }
    }

    public static String numToString(int num) {
        String before = num + "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6 - before.length(); i++) {
            sb.append("0");
        }
        return sb.append(before).toString();
    }

    private static Set<String> getPrimeNumberToN(int n) {
        Set<String> primes = new HashSet<>();
        boolean bool;
        for (int i = 3; i < n; i += 2) {
            bool = true;
            for (int j = 3; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) primes.add(numToString(i));
        }
        return primes;
    }
}
