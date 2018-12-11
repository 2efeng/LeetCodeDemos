package com.hzf.leetcode._003lengthOfLongestSubstring;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf.huang on 2018.11.28
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    private int lengthOfLongestSubstring(String s) {
        List<Character> subStr = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            subStr.clear();
            for (int j = i; j < s.length(); j++) {
                if (!subStr.contains(s.charAt(j))) {
                    subStr.add(s.charAt(j));
                    max = Math.max(max, subStr.size());
                }
            }
        }
        return max;
    }

    private int lengthOfLongestSubstring2(String s) {
        List<Character> subStr = new ArrayList<>();
        int max = 0, index = 0;
        while (index < s.length()) {
            if (!subStr.contains(s.charAt(index))) {
                subStr.add(s.charAt(index++));
                max = Math.max(max, subStr.size());
            } else {
                subStr.remove(0);
            }
        }
        return max;
    }
}
