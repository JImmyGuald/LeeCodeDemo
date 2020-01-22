package com.guald.demo.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author jayden.gan
 * @description
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ['1','0','1','0','0'],
 *   ['1','0','1','1','1'],
 *   ['1','1','1','1','1'],
 *   ['1','0','0','1','0']
 * ]
 * 输出: 6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @create 2020/1/15 18:35
 */
public class LC200115 {
    //解题思路：暴力法
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length>0) {
            int[][] a = new int[matrix.length][matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (j == 0) {
                        a[i][j] = matrix[i][j] - '0';
                        continue;
                    }
                    if (matrix[i][j] == '1') a[i][j] = a[i][j - 1] + 1;
                    else a[i][j] = 0;
                }
            }
            int maxArea = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        int minLength = Integer.MAX_VALUE;
                        for (int k = i; k > -1; k--) {
                            if (matrix[k][j] == '1') {
                                minLength = Math.min(minLength, a[k][j]);
                                int area = (i - k + 1) * minLength;
                                if (area > maxArea) maxArea = area;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return maxArea;
        }else {
            return 0;
        }
    }

    public static int maximalRectangle2(char[][] matrix) {
        int maxArea = 0;
        if(matrix.length>0) {
            int[] heights = new int[matrix[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '0') heights[j] = 0;
                    else heights[j] = heights[j] + 1;
                }
                int area = largestRectangleArea2(heights);
                if (area > maxArea) maxArea = area;
            }
        }
        return maxArea;
    }

    public static int maximalRectangle3(char[][] matrix) {
        int maxArea = 0;
        if(matrix.length>0) {
            int[] heights = new int[matrix[0].length];
            int[] left = new int[heights.length];
            int[] right = new int[heights.length];
            Arrays.fill(left,-1);
            Arrays.fill(right, matrix[0].length);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '0') heights[j] = 0;
                    else heights[j] = heights[j] + 1;
                }
                int binary = -1;//上次为0的下标
                for (int j = 0; j < matrix[0].length; j++) {
                    if(matrix[i][j] == '1'){
                        left[j] = Math.max(left[j], binary);
                    }else{
                        left[j] = -1;
                        binary = j;
                    }
                }
                binary = matrix[0].length;
                for (int j = matrix[0].length-1; j >= 0; j--) {
                    if(matrix[i][j] == '1'){
                        right[j] = Math.min(right[j], binary);
                    }else{
                        right[j] = matrix[0].length;
                        binary = j;
                    }
                }
                for(int k=0;k<heights.length;k++){
                    int area = (right[k] - left[k] - 1) * heights[k];
                    if(maxArea < area) maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static int largestRectangleArea2(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
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
                System.out.println(area);
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
       // System.out.println(maximalRectangle2(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(maximalRectangle3(new char[][]{{'1','0'}}));
    }

}
