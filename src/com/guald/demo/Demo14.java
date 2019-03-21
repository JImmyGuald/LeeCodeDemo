package com.guald.demo;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * 示例:
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class Demo14 {
    //思路：dp[i][j]代表以i，j为右下角的最长正方形边长
    //dp[i][j] = 1+min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])
    public int maximalSquare(char[][] matrix) {
        if(matrix.length<1) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int res = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == '1'){
                    dp[i+1][j+1] = 1+Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]));
                    if(dp[i+1][j+1]>res) res = dp[i+1][j+1];
                }
            }
        }
        return res*res;
    }
}
