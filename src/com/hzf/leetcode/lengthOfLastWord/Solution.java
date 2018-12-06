package com.hzf.leetcode.lengthOfLastWord;

/**
 * Created by zf.huang on 2018.12.3
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "";
        System.out.println(solution.lengthOfLastWord(str));
    }

    private int lengthOfLastWord(String s) {
        String[] strList = s.split(" ");
        if (strList.length < 1) return 0;
        return strList[strList.length - 1].length();
    }
}
