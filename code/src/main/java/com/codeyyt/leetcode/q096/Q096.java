package com.codeyyt.leetcode.q096;

/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

public class Q096 {

    public static void main(String[] args) {

        Q096 q139 = new Q096();
        System.out.println(new Q096().numTrees(3));

    }

    public int numTrees(int n) {
        // 分解成规模较小的两个子问题，且子问题的解可以复用
        // 发现重叠子问题
        if (n == 0) {
            return 1;
        }

        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;
        // 以i为根的二叉搜索树个数
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }
}








