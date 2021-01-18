package com.codeyyt.leetcode.q139;

/*
难度
中等

切换为英文

给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。

示例 3：
输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false

*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139 {

    public static void main(String[] args) {

        Q139 q139 = new Q139();

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("abc");
        list.add("b");
        list.add("cd");

        System.out.println(q139.wordBreak1("abcd", list));

    }

    // 解法1： 递归，暴力求解,会超时
    public boolean wordBreak1(String s, List<String> wordDict) {
        // 递归结束条件,当传入空字符串时，表示已经递归结束了，到达尾部了，此时可以返回ture了
        if (s.equals("")) {
            return true;
        }

        boolean result = false;
        // 业务逻辑
        // 取子串
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            // 如果子串在列表中,才能去递归剩余子串
            // 如果拿到的子串不在列表中，就不会去递归，直接返回false
            if (wordDict.contains(sub)) {
                // 继续接着来遍历剩余子串
                // 使用||，用于记录上一次执行的结果，只要有true就可以
                result = (result || wordBreak1(s.substring(i+1), wordDict));
            }
        }

        // 如果子串没有找到就会返回false
        return result;
    }

    // 解法2： 采用递归，对暴力遍历，存储中间值，减少遍历次数
    Set<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        // 递归结束条件,当传入空字符串时，表示已经递归结束了，到达尾部了，此时可以返回ture了
        if (s.equals("")) {
            return true;
        }

        // 先判断是否计算过
        if (set.contains(s)) {
            return false;
        }

        boolean result = false;
        // 业务逻辑
        // 取子串
        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            // 如果子串在列表中,才能去递归剩余子串
            // 如果拿到的子串不在列表中，就不会去递归，直接返回false
            if (wordDict.contains(sub)) {
                // 继续接着来遍历剩余子串
                // 使用||，用于记录上一次执行的结果，只要有true就可以
                result = (result || wordBreak(s.substring(i+1), wordDict));
                // 如果不存在就记录保存起来，避免下次重复计算
                if (!result) {
                    set.add(s.substring(i+1));
                }
            }
        }

        // 如果子串没有找到就会返回false
        return result;
    }
}








