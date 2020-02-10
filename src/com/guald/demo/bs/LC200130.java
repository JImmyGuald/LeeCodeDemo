package com.guald.demo.bs;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC200130 {

    //二分法
    public double findMedianSortednums1rrays(int[] nums1, int[] nums2) {
            if(nums1.length>nums2.length){
                int[] T = nums1;
                nums1 = nums2;
                nums2 = T;
            }
            int m = nums1.length;
            int n = nums2.length;
            int iMin = 0;
            int iMax = m;
            while (iMin <= iMax){
                int i = (iMin+iMax)/2;
                int j = (m+n+1)/2 - i;
                if(i<iMax && nums2[j-1]>nums1[i]){ // i is small
                    iMin = i+1;
                } else if(i>iMin && nums1[i-1]>nums2[j]){ // i is large
                    iMax = i-1;
                } else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) { maxLeft = nums2[j-1]; }
                    else if (j == 0) { maxLeft = nums1[i-1]; }
                    else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                    if ( (m + n) % 2 == 1 ) { return maxLeft; }

                    int minRight = 0;
                    if (i == m) { minRight = nums2[j]; }
                    else if (j == n) { minRight = nums1[i]; }
                    else { minRight = Math.min(nums2[j], nums1[i]); }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0;
    }

    static void  exchange(int m,int n){
        System.out.println(m+" "+n);
        m = m+n;
        n = m - n;
        m = m-n;
        System.out.println(m+" "+n);
    }

    public static void main(String[] args) {
        exchange(1,2);
    }
}
