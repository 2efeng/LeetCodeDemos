package com.hzf.leetcode.maximalRectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf.huang on 2018.12.4
 * <p>
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 */
public class Solution {

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        new Solution().test();
    }


    private int maximalRectangle(char[][] matrix) {

        int maxArea = 0;

        List<List<Character>> rectangle = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) break;

            }
            rectangle.clear();
        }
        return maxArea;
    }


    public void test() {
        try {
            while (true) ;
        } finally {
            System.out.println("finally block");

        }
    }


}
