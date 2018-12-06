package com.hzf.leetcode.getRow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zf.huang on 2018.12.3
 */
public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(1));
        for (int i = 1; i < rowIndex+1; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> lastRow = triangle.get(i - 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(lastRow.get(j - 1) + lastRow.get(j));
            }
            triangle.add(row);
        }
        return triangle.get(rowIndex);
    }
}
