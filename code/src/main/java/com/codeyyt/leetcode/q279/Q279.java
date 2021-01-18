package com.codeyyt.leetcode.q279;

/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.


*/

import java.util.HashMap;
import java.util.Map;

public class Q279 {

    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Q279().numSquares(12));

    }

    // 解法1 动态规划
    public int numSquares(int n) {
        // 构造dp数组来存储中间值
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况是都是1,即有n个
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                // 动态转移方程
                // 使用i减去一个平方数，去找这个数的平方数的最小个数，
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

}











