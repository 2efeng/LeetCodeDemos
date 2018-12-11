package com.hzf.leetcode._084largestRectangleArea;

import java.util.Stack;

/**
 * Created by zf.huang on 2018.12.4
 * <p>
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 */
public class Solution {

    public static void main(String[] args) {
//        int[] heights = {2, 1, 5, 6, 2, 3};
        int[] heights = {1,2,2};
        System.out.println(new Solution().largestRectangleArea(heights));
    }

    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length < 1) return 0;
        Stack<Integer> indexs = new Stack<>();
        int index, maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (indexs.empty() || heights[i] > heights[indexs.peek()]) {
                indexs.push(i);
                continue;
            }
            while (heights[i] <= heights[indexs.peek()]) {
                index = indexs.pop();
                if (indexs.empty()) {
                    maxArea = Math.max(maxArea, heights[index] * i);
                    break;
                }
                maxArea = Math.max(maxArea, heights[index] * (i - index));
            }
            indexs.push(i);
        }
        while (!indexs.empty()) {
            index = indexs.pop();
            int length;
            if (indexs.empty()) length = heights.length;else length = heights.length-index - indexs.peek();

            maxArea = Math.max(maxArea, length * heights[index]);
        }
        return maxArea;
    }
}
