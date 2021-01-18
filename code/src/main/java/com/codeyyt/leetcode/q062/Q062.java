package com.codeyyt.leetcode.q062;

/*

给你一个字符串 s，找到 s 中最长的回文子串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：

输入：s = "cbbd"
输出："bb"

*/

public class Q062 {

    public static void main(String[] args) {

        Q062 q139 = new Q062();
        System.out.println(q139.uniquePaths(3, 7));

    }

    // 解法1 动态规划
    public int uniquePaths(int m, int n) {
        // 临界条件
        if (m < 1 || n < 1) {
            return 0;
        }

        // 定义dp
        int[][] dp = new int[m+1][n+1];

        // 确定初始状态
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= m; i++ ) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }

}








