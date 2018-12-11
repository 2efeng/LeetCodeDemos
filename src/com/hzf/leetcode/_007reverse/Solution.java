package com.hzf.leetcode._007reverse;

/**
 * Created by zf.huang on 2018.12.3
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 1534236469;
        System.out.println(solution.reverse(num));
    }

    private int reverse(int x) {
        int num, result = 0;
        while (x != 0) {
            num = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && num > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && num < -8)) return 0;
            result = result * 10 + num;
        }
        return result;


    }
}
