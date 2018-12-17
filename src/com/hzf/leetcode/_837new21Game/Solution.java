package com.hzf.leetcode._837new21Game;

/**
 * Created by zf.huang on 2018.12.14
 * <p>
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 * <p>
 * 示例 1：
 * 输入：N = 10, K = 1, W = 10
 * 输出：1.00000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 示例 2：
 * 输入：N = 6, K = 1, W = 10
 * 输出：0.60000
 * 说明：爱丽丝得到一张卡，然后停止。
 * 在 W = 10 的 6 种可能下，她的得分不超过 N = 6 分。
 * 示例 3：
 * 输入：N = 21, K = 17, W = 10
 * 输出：0.73278
 * <p>
 * 提示：
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * 如果答案与正确答案的误差不超过 10^-5，则该答案将被视为正确答案通过。
 * 此问题的判断限制时间已经减少。
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().new21Game(10, 1, 10));
        System.out.println(new Solution().new21Game(6, 1, 10));
        System.out.println(new Solution().new21Game(21, 17, 9));
    }

    private double new21Game(int N, int K, int W) {
        return take(N, K, W, 0) / time;
    }

    private double time = 0;

    private int take(int n, int k, int w, int num) {
        if (k <= 0) return 0;
        if (num >= k) return 1;
        int temp = 0;
        if (num >= n) {
            for (int i = 1; i < w; i++) {
                temp = take(n, k, w, num + i) + 1;
            }
            time += w;
            return temp;
        }
        int remain = n - num;
        if (remain > w) {
            for (int i = 0; i < w; i++) {
                temp = take(n, k, w, num + i);
            }
            time += w;
            return temp;
        }
        for (int i = 0; i < remain; i++) {
            temp = take(n, k, w, num + i);
        }
        for (int i = remain; i < w; i++) {
            temp = take(n, k, w, num + i) + 1;
        }
        time += w;
        return temp;
    }


}
