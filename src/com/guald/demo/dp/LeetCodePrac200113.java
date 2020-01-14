package com.guald.demo.dp;

/**
 * @author jayden.gan
 * @description
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 *
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 *
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @create 2020/1/13 14:13
 */
public class LeetCodePrac200113 {
    //编辑差异算法 dp[i][j] 表示word1前i个字符到word2前j个字符的编辑差距D
    //则可以得到当word1[i] == word2[j] 则 dp[i][j] = dp[i-1][j-1]
    //当word1[i] != word2[j] 则 dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1
    //其中dp[i-1][j-1] dp[i-1][j] dp[i][j-1] 分别对应替换、删除、插入操作
    //边界情况dp[0][j] = j, dp[i][0] = i
    public static int execute(String word1,String word2){
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i <= word1.length();i++){
            for(int j = 0;j <= word2.length();j++) {
                if(j ==0) {dp[i][j] = i;continue;}
                if(i == 0) {dp[i][j] = j;continue;}
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(execute("horse","ros"));
    }
}
