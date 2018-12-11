package com.hzf.leetcode._557reverseWords;

/**
 * Created by zf.huang on 2018.12.10
 */
public class Solution {

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String res = "s'teL ekat edoCteeL tsetnoc";
        String result = new Solution().reverseWords(s);
        System.out.println(result);
        System.out.println(result.equals(res));
    }

    public String reverseWords(String s) {
        if (s.equals(" ")) return s;
        StringBuilder builder = new StringBuilder();
        int start = 0, index = s.indexOf(" ");
        while (index != -1) {
            builder.append(reverse(s.substring(start, start = +index)))
                    .append(" ");
            index = s.indexOf(" ", ++start);
        }
        builder.append(reverse(s.substring(start)));
        return builder.toString();
    }

    private String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }
}
