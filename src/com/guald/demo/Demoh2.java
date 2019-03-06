package com.guald.demo;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class Demoh2 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for(int i=1;i<height.length;i++){
            left[i] = Math.max(left[i-1],height[i-1]);
        }
        for(int i=height.length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i+1]);
        }
        int res = 0;
        for(int i=0;i<height.length;i++){
            int min = Math.min(left[i],right[i]);
            res += Math.max(0,min-height[i]);
        }
        return res;
    }
}
