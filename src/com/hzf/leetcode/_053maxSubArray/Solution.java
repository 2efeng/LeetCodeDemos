package com.hzf.leetcode._053maxSubArray;

/**
 * Created by zf.huang on 2018.12.11
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Solution {

    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int maxSum = nums[0], tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum > 0) tempSum += nums[i];
            else tempSum = nums[i];
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}
