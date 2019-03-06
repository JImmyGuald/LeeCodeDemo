package com.guald.demo;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class Demo10 {
    //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
    public int search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }

    public int search(int[] nums, int l, int r, int target){
        if(l>r) return -1;
        int mid = (l+r)/2;
        if(nums[mid] == target) return mid;
        if(nums[mid] < nums[r]){
            if(nums[mid] < target && nums[r] >= target){
                return search(nums,mid+1,r,target);
            }else{
                return search(nums,l,mid-1,target);
            }
        }else {
            if (nums[mid] > target && nums[l] <= target) {
                return search(nums, l, mid - 1, target);
            } else {
                return search(nums, mid + 1, r, target);
            }
        }
    }
}
