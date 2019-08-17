package com.eva.solution.leetcode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Author EvaJohnson
 * @Date 2019-08-17
 * @Email g863821569@gmail.com
 */

/**
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * <p>
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        if (letters[l] == letters[r]) {
            return letters[l];
        }
        while (l < r) {
            int mid = (l + r) / 2;
            if (letters[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
            if (r >= 0 && letters[r] == letters[l]) {
                if (letters[l] > target) return letters[l];
                for (int i = Math.min(l, r); i < letters.length; i++) {
                    if (letters[i] > target)
                        return letters[i];
                }
                return letters[0];
            }
        }
        if (r < 0) r = 0;
        if (letters[r] > target)
            return letters[r];
        else
            return letters[(r + 1) % letters.length];
    }

    public static char nextGreatestLetter2(char[] letters, char target) {
        int len = letters.length;
        int l = 0;
        int r = len - 1;
        if (letters[l] == letters[r])
            return letters[l];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target < letters[mid])
                r = mid - 1;
            else
                l = mid + 1;
        }
        return letters[l % len];
    }

    public static char nextGreatestLetter1(char[] letters, char target) {
        Set<Character> chars = new TreeSet<>();
        for (char letter : letters) {
            chars.add(letter);
        }
        Character[] characters = chars.toArray(new Character[]{});
        if (characters.length == 1) {
            return letters[0];
        }
        int l = 0, r = characters.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (characters[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        if (r < 0) r = 0;
        if (characters[r] > target)
            return characters[r];
        else
            return characters[(r + 1) % characters.length];
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'e', 'e', 'e', 'k', 'q', 'q', 'q', 'v', 'v', 'y'}, 'a'));
        System.out.println(nextGreatestLetter1(new char[]{'e', 'e', 'e', 'k', 'q', 'q', 'q', 'v', 'v', 'y'}, 'a'));
    }

}
