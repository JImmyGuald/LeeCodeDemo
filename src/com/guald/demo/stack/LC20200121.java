package com.guald.demo.stack;

import java.util.Stack;

/**
 * @author jayden.gan
 * @description
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/1/21 14:02
 */
public class LC20200121 {
    public static int largestRectangleArea(int[] heights) {
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            if(i == 0) {
                left[i] = -1;
                continue;
            }
            int l = i-1;
            while(l > -1 && heights[l] >= heights[i]){
                l--;
            }
            left[i] = l;
        }
        for(int i=0;i<heights.length;i++){
            if(i == heights.length-1) {
                right[i] = heights.length;
                continue;
            }
            int r = i+1;
            while(r < heights.length && heights[r] >= heights[i]){
                r++;
            }
            right[i] = r;
        }
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int area = (right[i] - left[i] - 1) * heights[i];
            if(maxArea < area) maxArea = area;
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int left[] = new int[heights.length];
        int right[] = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            if(i == 0) {
                left[i] = -1;
                continue;
            }
            int l = i-1;
            while(l > -1 && heights[l] >= heights[i]){
                l = left[l];
            }
            left[i] = l;
        }
        for(int i=heights.length-1;i>=0;i--){
            if(i == heights.length-1) {
                right[i] = heights.length;
                continue;
            }
            int r = i+1;
            while(r < heights.length && heights[r] >= heights[i]){
                r = right[r];
            }
            right[i] = r;
        }
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            int area = (right[i] - left[i] - 1) * heights[i];
            if(maxArea < area) maxArea = area;
        }
        return maxArea;
    }

    public static int largestRectangleArea3(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            while (stack.peek()!=-1 && heights[i] <= heights[stack.peek()]){
                int area = heights[stack.pop()] * (i-stack.peek()-1);
                if(area > maxArea) maxArea = area;
            }
            stack.push(i);
        }
        while (stack.peek()!=-1){
            int area = heights[stack.pop()] * (heights.length-stack.peek()-1);
            if(area > maxArea) maxArea = area;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea3(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
