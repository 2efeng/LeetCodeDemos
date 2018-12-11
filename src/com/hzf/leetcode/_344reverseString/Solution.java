package com.hzf.leetcode._344reverseString;

/**
 * Created by zf.huang on 2018.12.10
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("hello"));
    }

    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        char temp;
        while (left < right) {
            temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
        return String.valueOf(chars);
    }
}
