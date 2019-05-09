package com.eva.solution.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author EvaJohnson
 * @Date 2019-05-09
 * @Email g863821569@gmail.com
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        Pattern compile = Pattern.compile(p);
        Matcher matcher = compile.matcher(s);
        return matcher.matches();
    }
}
