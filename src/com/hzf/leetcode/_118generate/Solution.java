package com.hzf.leetcode._118generate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zf.huang on 2018.12.3
 * <p>
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 * <p>
 * 示例:
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * [1,5,10,10,5,1]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int numRows = 8;
        for (List<Integer> list : solution.generate(numRows)) {
            for (int a : list) {
                System.out.print(a + "\t");
            }
            System.out.println();
        }
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) return triangle;
        triangle.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> lastRow = triangle.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            triangle.add(row);
        }
        return triangle;
    }
}
