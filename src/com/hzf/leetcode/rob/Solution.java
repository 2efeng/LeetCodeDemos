package com.hzf.leetcode.rob;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zf.huang on 2018.12.3
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        System.out.println(solution.rob(nums));
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int tempMoney, lastMax = nums[0];
        int curMax = Math.max(lastMax, nums[1]);
        for (int i = 2; i < nums.length; i++) {
            tempMoney = curMax;
            curMax = Math.max((lastMax + nums[i]), curMax);
            lastMax = tempMoney;
        }
        return curMax;
    }

    /**
     * 动态规划
     */
    private int rob(int[] nums) {
        return maxMoney(nums, nums.length - 1);
    }

    private Map<Integer, Integer> money = new HashMap<>();

    private int maxMoney(int[] nums, int index) {
        if (money.containsKey(index)) return money.get(index);
        if (nums.length == 0) return 0;
        if (index == 0) return nums[0];
        if (index == -1) return 0;
        int max = Math.max(nums[index] + maxMoney(nums, index - 2), maxMoney(nums, index - 1));
        money.put(index, max);
        return max;
    }






}
