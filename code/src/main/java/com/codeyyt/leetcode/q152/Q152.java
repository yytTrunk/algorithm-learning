package com.codeyyt.leetcode.q152;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。


*/

public class Q152 {

    public static void main(String[] args) {
        int[] nums = new int[]{-2};
        Q152 q152 = new Q152();

        q152.maxProduct(nums);
        System.out.println(q152.maxVal);

    }

//    public int maxProduct(int[] nums) {
//
//        product(nums);
//        return maxVal;
//    }

    // 方法1 暴力遍历,两个指针
    int maxVal = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {
        int val = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                val = val * nums[j];
              //  System.out.println("val = " + val + " nums = " + nums[j]);
                maxVal = val > maxVal ? val : maxVal;
            }
            val = 1;
        }

        return maxVal;
    }

}








