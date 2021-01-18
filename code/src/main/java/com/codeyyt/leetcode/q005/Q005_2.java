package com.codeyyt.leetcode.q005;

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

public class Q005_2 {

    public static void main(String[] args) {

        Q005_2 q139 = new Q005_2();

        System.out.println(q139.longestPalindrome("bb"));
    }

    // 动态规划
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        // 初始状态
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 只记录起始位置，和长度，最后再进行截取
        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}








