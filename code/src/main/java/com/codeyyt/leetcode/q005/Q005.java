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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q005 {

    public static void main(String[] args) {

        Q005 q139 = new Q005();

        System.out.println(q139.longestPalindrome("babad"));

        System.out.println("123456".substring(1, 3));
    }

    // 解法1 超时
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        char[] chars = s.toCharArray();
        // 只记录起始位置，和长度，最后再进行截取
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i+1; j < len; j++) {
                if (j - i + 1 > maxLen && isPalindrome(chars, i, j)) {
                    begin = i;
                    maxLen = j - i + 1;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public boolean isPalindrome(char[] chars, int begin, int end) {
        while(begin < end) {
            if (chars[begin] != chars[end]) {
                return false;
            }
            begin++;
            end--;
        }

        return true;
    }
}








