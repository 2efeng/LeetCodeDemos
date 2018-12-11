package com.hzf.leetcode._002addTwoNumbers;

/**
 * Created by zf.huang on 2018.11.28
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in _007reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node_1 = solution.int2node(1);
        ListNode node_2 = solution.int2node(99);
        ListNode resultNode = solution.addTwoNumbers(node_1, node_2);
        while (resultNode != null) {
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return solution1(l1, l2);
//        return solution2(l1, l2);
        return solution3(l1, l2);
    }

    /**
     * 第一种
     */
    private ListNode solution1(ListNode l1, ListNode l2) {
        int num_1 = node2int(l1);
        int num_2 = node2int(l2);
        return int2node(num_1 + num_2);
    }

    private int node2int(ListNode node) {
        int num = 0, curr = 1;
        while (node != null) {
            num += node.val * curr;
            curr *= 10;
            node = node.next;
        }
        return num;
    }

    private ListNode int2node(int num) {
        ListNode node = new ListNode(num % 10);
        ListNode temp = node;
        num /= 10;
        while (num != 0) {
            ListNode nextNode = new ListNode(num % 10);
            temp.next = nextNode;
            temp = nextNode;
            num /= 10;
        }
        return node;
    }

    /**
     * 第二种
     */
    private ListNode solution2(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int decade) {
        if (l1 == null && l2 == null)
            return decade == 0 ? null : new ListNode(decade);
        if (l1 == null) l1 = new ListNode(0);
        if (l2 == null) l2 = new ListNode(0);
        int sum = l1.val + l2.val + decade;
        ListNode currNode = new ListNode(sum % 10);
        currNode.next = add(l1.next, l2.next, sum / 10);
        return currNode;
    }

    /**
     * 第三种
     */
    private ListNode solution3(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        ListNode currNode = resNode;
        int decade = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            currNode.next = new ListNode((l1.val + l2.val + decade) % 10);
            currNode = currNode.next;
            decade = (l1.val + l2.val + decade) / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (decade > 0) {
            currNode.next = new ListNode(decade);
        }
        return resNode.next;
    }

}
