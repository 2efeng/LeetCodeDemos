package com.hzf.leetcode._062uniquePaths;

/**
 * Created by zf.huang on 2018.12.12
 * <p>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * <p>
 * 例如 一个7 x 3 的网格。有多少可能的路径？
 * 说明：m 和 n 的值均不超过 100。
 * <p>
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * <p>
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().uniquePaths(3, 2));

    }

    private int[][] cache;

    public int uniquePaths(int m, int n) {
        cache = new int[m + 1][n + 1];
        return move(m, n);
    }

    private int move(int m, int n) {
        if (cache[m][n] != 0) return cache[m][n];
        if (m == 1 && n == 1) return 1;
        if (m == 1) cache[m][n] = move(m, n - 1);
        else if (n == 1) cache[m][n] = move(m - 1, n);
        else cache[m][n] = move(m - 1, n) + move(m, n - 1);
        return cache[m][n];
    }


}
