package com.hzf.leetcode._374guessNumber;

/**
 * Created by zf.huang on 2018.12.13
 * <p>
 * 我们正在玩一个猜数字游戏。 游戏规则如下：
 * 我从 1 到 n 选择一个数字。 你需要猜我选择了哪个数字。
 * 每次你猜错了，我会告诉你这个数字是大了还是小了。
 * 你调用一个预先定义好的接口 guess(int num)，它会返回 3 个可能的结果（-1，1 或 0）：
 * -1 : 我的数字比较小
 * 1 : 我的数字比较大
 * 0 : 恭喜！你猜对了！
 * 示例 :
 * 输入: n = 10, pick = 6
 * 输出: 6
 */
public class Solution {

    private static int number;

    private int guess(int num) {
        return Integer.compare(num, number);
    }

    public static void main(String[] args) {
        number = 7;
        int n = 10;
        System.out.println(new Solution().guessNumber(n));
    }

    private int guessNumber(int n) {
        int middle = 0, left = 1, right = n;
        while (left < right) {
            middle = (left + right) / 2;
            int res = guess(middle);
            if (res == 0) return middle;
            if (res == 1) right = middle;
            else left = middle;
        }
        return middle;
    }

}
