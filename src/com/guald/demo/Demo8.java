package com.guald.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Demo8 {
    //解题思路：从小到大排序，将a+b+c=0转换为-a=b+c的问题，注意去重的问题
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i == 0 || (i>0 && nums[i]!=nums[i-1])) {//去重
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == -nums[i]) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] > -nums[i]) {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    } else {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
