package com.hzf.leetcode._746minCostClimbingStairs;

/**
 * Created by zf.huang on 2018.12.12
 * <p>
 * 数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 * <p>
 * 示例 1:
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 * <p>
 * 示例 2:
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * <p>
 * 注意：
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
 */
public class Solution {

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }

    private int[] cache;

    public int minCostClimbingStairs(int[] cost) {
        cache = new int[cost.length + 1];
        return Math.min(climb(cost, 0), climb(cost, 1));
    }

    private int climb(int[] cost, int index) {
        if (cache[index] != 0) return cache[index];
        if (index == cost.length) return 0;
        if (index == cost.length - 1) return cost[index];
        cache[index] = Math.min(climb(cost, index + 1), climb(cost, index + 2)) + cost[index];
        return cache[index];
    }
}
