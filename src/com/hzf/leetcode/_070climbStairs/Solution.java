package com.hzf.leetcode._070climbStairs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zf.huang on 2018.12.4
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class Solution {

    public static void main(String[] args) {
        int n = 1;
        System.out.println(new Solution().climbStairs(n));
    }

    public int climbStairs(int n) {
        if (n == 0) return 0;
        stairs = new int[n + 1];
        return climb(n);
    }

    private int[] stairs;

    private int climb(int remain) {
        if (stairs[remain] != 0) return stairs[remain];
        if (remain < 2) return 1;
        int stair = climb(remain - 1) + climb(remain - 2);
        stairs[remain] = stair;
        return stair;
    }
}
