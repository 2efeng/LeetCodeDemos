package com.hzf.leetcode._221maximalSquare;

/**
 * Created by zf.huang on 2018.12.12
 * <p>
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * 输出: 4
 */
public class Solution {


    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(new Solution().maximalSquare(matrix));
    }

    private int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = square(matrix, matrix.length - 1, matrix[0].length - 1) - '0';
        return res * res;
    }


    private int square(char[][] matrix, int x, int y) {
        if (x == 0 || y == 0) return matrix[x][y];
        if (matrix[x][y] == '0') {
            return square(matrix, x - 1, y - 1);
        }
        int temp = Math.min(square(matrix, x, y - 1), square(matrix, x - 1, y));
        return Math.min(temp, square(matrix, x - 1, y - 1)) + matrix[x][y];
    }


}
