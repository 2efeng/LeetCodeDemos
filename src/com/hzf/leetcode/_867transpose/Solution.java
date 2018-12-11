package com.hzf.leetcode._867transpose;

import java.util.Arrays;

/**
 * Created by zf.huang on 2018.12.10
 */
public class Solution {

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}};
        int[][] res = new Solution().transpose(a);
        System.out.println(Arrays.deepToString(res));
    }

    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                if (i == j) res[i][j] = A[i][j];
                else res[i][j] = A[j][i];
            }
        }
        return res;
    }
}
