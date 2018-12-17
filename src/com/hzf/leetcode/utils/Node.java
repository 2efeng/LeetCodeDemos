package com.hzf.leetcode.utils;

import java.util.List;

/**
 * Created by zf.huang on 2018.12.17
 */
public class Node {

    public int val;

    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
