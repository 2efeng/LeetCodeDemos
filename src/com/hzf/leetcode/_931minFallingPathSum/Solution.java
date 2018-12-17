package com.hzf.leetcode._931minFallingPathSum;

/**
 * Created by zf.huang on 2018.12.12
 * <p>
 * 给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 * 示例：
 * 输入：
 * [[1,2,3],
 * [4,5,6],
 * [7,8,9]]
 * 输出：12
 * 解释：
 * 可能的下降路径有：
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * 和最小的下降路径是 [1,4,7]，所以答案是 12。
 * 提示：
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class Solution {

    public static void main(String[] args) {
        int[][] A1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] A2 = {{17, 82}, {1, -44}};
        System.out.println(new Solution().minFallingPathSum(A1));
        System.out.println(new Solution().minFallingPathSum(A2));
    }

    private int[][] cache;

    private int minFallingPathSum(int[][] A) {
        cache = new int[A.length][A[0].length];
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < A[0].length; i++)
            minPath = Math.min(minPath, down(A, A.length - 1, i));
        return minPath;
    }

    private int down(int[][] A, int x, int y) {
        if (cache[x][y] != 0) return cache[x][y];
        if (x == 0) return A[x][y];
        if (y == 0) cache[x][y] = Math.min(down(A, x - 1, y + 1), down(A, x - 1, y)) + A[x][y];
        else if (y == A[0].length - 1) cache[x][y] = Math.min(down(A, x - 1, y - 1), down(A, x - 1, y)) + A[x][y];
        else {
            int temp = Math.min(down(A, x - 1, y + 1), down(A, x - 1, y - 1));
            cache[x][y] = Math.min(temp, down(A, x - 1, y)) + A[x][y];
        }
        return cache[x][y];
    }

}
