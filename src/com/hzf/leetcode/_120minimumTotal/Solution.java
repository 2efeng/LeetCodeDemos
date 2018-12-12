package com.hzf.leetcode._120minimumTotal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by zf.huang on 2018.12.12
 * <p>
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 * *****[2],
 * ****[3,4],
 * ***[6,5,7],
 * **[4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
public class Solution {

    public static void main(String[] args) {
        List<Integer> row1 = Collections.singletonList(2);
        List<Integer> row2 = Arrays.asList(3, 4);
        List<Integer> row3 = Arrays.asList(6, 5, 7);
        List<Integer> row4 = Arrays.asList(4, 1, 8, 3);
        List<List<Integer>> triangle = Arrays.asList(row1, row2, row3, row4);
        System.out.println(new Solution().minimumTotal(triangle));
    }


    private int[][] cache;

    public int minimumTotal(List<List<Integer>> triangle) {
        cache = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        return down(triangle, 0, 0);
    }

    private int down(List<List<Integer>> triangle, int row, int index) {
        if (cache[row][index] != 0) return cache[row][index];
        if (row == triangle.size() - 1) return triangle.get(row).get(index);
        cache[row][index] = Math.min(down(triangle, row + 1, index), down(triangle, row + 1, index + 1)) + triangle.get(row).get(index);
        return cache[row][index];
    }
}
