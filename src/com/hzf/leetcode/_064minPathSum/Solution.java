package com.hzf.leetcode._064minPathSum;

/**
 * Created by zf.huang on 2018.12.11
 * <p>
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solution().minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        cache = new int[grid.length + 1][grid[0].length + 1];
        return move(grid, grid.length - 1, grid[0].length - 1);
    }

    private int[][] cache;

    private int move(int[][] grid, int m, int n) {
        if (cache[m][n] != 0) return cache[m][n];
        if (m == n && n == 0) return grid[m][n];
        if (m == 0) return move(grid, m, n - 1) + grid[m][n];
        if (n == 0) return move(grid, m - 1, n) + grid[m][n];
        cache[m][n] = Math.min(move(grid, m, n - 1), move(grid, m - 1, n)) + grid[m][n];
        return cache[m][n];
    }
}
