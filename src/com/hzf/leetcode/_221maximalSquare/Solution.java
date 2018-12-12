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

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        cache = new int[matrix.length][matrix[0].length];
        int res = square(matrix, 0, 0) - '0';
        return res * res;
    }

    private int[][] cache;

    private int square(char[][] matrix, int x, int y) {
        if (cache[x][y] != 0) return cache[x][y];
        if (x == matrix.length - 1 || y == matrix[0].length - 1) cache[x][y] = matrix[x][y];
        else {
            int temp = Math.min(square(matrix, x, y + 1), square(matrix, x + 1, y));
            cache[x][y] = Math.min(temp, square(matrix, x + 1, y + 1)) + cache[x][y];
        }
        return cache[x][y];
    }


}
