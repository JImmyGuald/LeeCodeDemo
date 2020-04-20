package com.guald.demo;

/**
 * @author jayden.gan
 * @description
 * 这里有 d 个一样的骰子，每个骰子上都有 f 个面，分别标号为 1, 2, ..., f。
 *
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 *
 * 如果需要掷出的总点数为 target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模 10^9 + 7 后返回。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：d = 1, f = 6, target = 3
 * 输出：1
 * 示例 2：
 *
 * 输入：d = 2, f = 6, target = 7
 * 输出：6
 * 示例 3：
 *
 * 输入：d = 2, f = 5, target = 10
 * 输出：1
 * 示例 4：
 *
 * 输入：d = 1, f = 2, target = 3
 * 输出：0
 * 示例 5：
 *
 * 输入：d = 30, f = 30, target = 500
 * 输出：222616187
 *  
 *
 * 提示：
 *
 * 1 <= d, f <= 30
 * 1 <= target <= 1000
 *
 * @create 2020/4/13 17:58
 */
public class LC200413 {
    //动态规划
    //状态：dp[i][j]表示掷i个色子和为j的个数
    //方程：dp[i][j] = dp[i-1][j-1]+dp[i-1][j-2]+...+dp[i-1][j-f]
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = 1000000007;
        int[][] dp = new int[31][1001];
        for(int i=1;i<=f;i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<=d;i++){
            int min = Math.min(i*f,target);
            for(int j=i;j<=min;j++){
                for(int k=1;j-k>0 && k <= f;k++) {
                    dp[i][j] = (dp[i][j]+dp[i-1][j-k])%MOD;
                }
            }
        }
        return dp[d][target];
    }
}
