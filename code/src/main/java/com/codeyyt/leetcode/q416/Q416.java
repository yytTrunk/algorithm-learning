package com.codeyyt.leetcode.q416;

/*

给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q416 {

    public static void main(String[] args) {

//        Q416 q139 = new Q416();
//
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("abc");
//        list.add("b");
//        list.add("cd");
//
//        System.out.println(q139.canPartition("abcd", list));

    }

    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        // 求sum
        int numsSum = 0;
         int maxNum = 0;
        for (int num : nums) {
            numsSum = numsSum + num;
            maxNum = Math.max(maxNum, num);
        }
        if (numsSum % 2 != 0) {
            return false;
        }
        if (maxNum > numsSum / 2) {
            return false;
        }

        // 定义dp
        boolean[][] dp = new boolean[nums.length][numsSum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 1; j <= numsSum / 2; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        return dp[nums.length-1][numsSum/2];

    }
}








