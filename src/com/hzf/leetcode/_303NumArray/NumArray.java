package com.hzf.leetcode._303NumArray;

/**
 * Created by zf.huang on 2018.12.11
 */
public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];
        if (nums.length == 0) return;
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (i == 0) return sums[j];
        return sums[j] - sums[i - 1];
    }


}
