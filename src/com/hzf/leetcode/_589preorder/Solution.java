package com.hzf.leetcode._589preorder;

import com.hzf.leetcode.utils.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zf.huang on 2018.12.17
 */
public class Solution {


    public List<Integer> preorder(Node root) {
        traversal(root);
        return res;
    }

    private List<Integer> res = new ArrayList<>();

    private void traversal(Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node node : root.children) {
            preorder(node);
        }

    }


}
