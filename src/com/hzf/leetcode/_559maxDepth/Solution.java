package com.hzf.leetcode._559maxDepth;

import com.hzf.leetcode.utils.Node;

/**
 * Created by zf.huang on 2018.12.17
 */
public class Solution {

    public int maxDepth(Node root) {
        if (root == null) return 0;
        int depth = 0;
        for (Node child : root.children) {
            depth = Math.max(depth, maxDepth(child));
        }
        return depth + 1;
    }


}
