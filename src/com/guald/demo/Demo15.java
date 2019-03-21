package com.guald.demo;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Demo15 {
    //思路：a[n] 表示第n个数结尾的最大子序和
    //则有：a[n] = max(a[n-1]+p[n],p[n])
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] res = new int[nums.length];
        int max = nums[0];
        res[0] = nums[0];
        for(int i=1;i<nums.length;i++){
              res[i] = Math.max(res[i-1]+nums[i],nums[i]);
              max = Math.max(res[i],max);
        }
        return max;
    }
}