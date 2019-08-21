package com.github.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * @author shaojie
 * @since 2019/4/2
 */
public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            Integer index = map.get(s.charAt(i));
            if (index != null) {
                max = index - begin + 1;
                begin = index + 1;
            }
            if (i == s.length() - 1) {
                max = (i - begin + 1) > max ? (i - begin + 1) : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

}
