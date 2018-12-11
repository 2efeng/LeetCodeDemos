package com.hzf.leetcode._541reverseStr;

/**
 * Created by zf.huang on 2018.12.10
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
        System.out.println(new Solution().reverseStr("abcdefgabcdefg", 3));
    }

    public String reverseStr(String s, int k) {
        StringBuilder builder = new StringBuilder();
//        int end, start = 0;
//        while (start < s.length()) {
//            if ((end = start + k) >= s.length()) {
//                builder.append(_007reverse(s.substring(start)));
//                break;
//            }
//            builder.append(_007reverse(s.substring(start, end)));
//            if (end + k >= s.length()) {
//                builder.append(s.substring(start + k));
//                break;
//            }
//            builder.append(s, start + k, start += 2 * k);
//        }

        int index;
        for (int i = 0; i < s.length(); i += 2 * k) {
            if ((index = i + k) >= s.length()) {
                builder.append(reverse(s.substring(i)));
                break;
            }
            builder.append(reverse(s.substring(i, index)));
            if (index + k >= s.length()) {
                builder.append(s.substring(index));
                break;
            }
            builder.append(s, index, index + k);
        }
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
