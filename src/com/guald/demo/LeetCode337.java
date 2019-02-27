package com.guald.demo;

import java.util.List;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class LeetCode337 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int[] dg(TreeNode treeNode){
        if(treeNode == null) return new int[2];
        int left[] = dg(treeNode.left);
        int right[] = dg(treeNode.right);
        int[] res = new int[2];
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        res[1] = treeNode.val + left[0] + right[0];
        return res;
    }

    public static TreeNode createTree(List<String> strs){
        if(strs == null || strs.size() == 0 || "null".equals(strs.get(0))) return null;
        TreeNode treeNode = new TreeNode(Integer.valueOf(strs.get(0)));
        TreeNode[] treeNodes = new TreeNode[strs.size()];
        treeNodes[0] = treeNode;
        for(int i=1;i<strs.size();i++){
            //找到其父节点
            int j = (i+1)/2;
            if(!"null".equals(strs.get(i))){
                TreeNode t = new TreeNode(Integer.valueOf(strs.get(i)));
                if(i%2>0){
                    treeNodes[j-1].left = t;
                }else{
                    treeNodes[j-1].right = t;
                }
                treeNodes[i] = t;
            }else{
                if(i%2>0){
                    treeNodes[j-1].left = null;
                }else{
                    treeNodes[j-1].right = null;
                }
            }
        }
        return treeNode;
    }

    public int rob(TreeNode root) {
        int[] res = dg(root);
        return Math.max(res[0],res[1]);
    }
}
