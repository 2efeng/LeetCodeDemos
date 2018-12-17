package com.hzf.leetcode._590postorder;

import com.hzf.leetcode.utils.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf.huang on 2018.12.17
 */
public class Solution {

    public List<Integer> postorder(Node root) {
        traversal(root);
        return res;
    }

    private List<Integer> res = new ArrayList<>();

    private void traversal(Node root) {
        if (root == null) return;
        for (Node node : root.children) {
            traversal(node);
        }
        res.add(root.val);

    }
}
