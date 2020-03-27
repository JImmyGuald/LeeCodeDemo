package com.guald.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author jayden.gan
 * @description
 * @create 2020/3/27 14:43
 */
public class LC200327 {

    class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) {
              val = x;
          }
    }

    class PackTreeNode{
        TreeNode treeNode;
        int pos;
        int level;

        public PackTreeNode(TreeNode treeNode,int level,int pos) {
            this.treeNode = treeNode;
            this.pos = pos;
            this.level = level;
        }
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<PackTreeNode> queue = new LinkedList<>();
        queue.add(new PackTreeNode(root,1,1));
        int res = 1,left = 1,level = 1;
        while (!queue.isEmpty()){
            PackTreeNode packTreeNode = queue.poll();
            if(packTreeNode.treeNode != null){
                queue.add(new PackTreeNode(packTreeNode.treeNode.left,packTreeNode.level+1,2*packTreeNode.pos));
                queue.add(new PackTreeNode(packTreeNode.treeNode.right,packTreeNode.level+1,2*packTreeNode.pos+1));
                if(packTreeNode.level>level){
                    level = packTreeNode.level;
                    left = packTreeNode.pos;
                }
                if(res < (packTreeNode.pos-left+1)){
                    res = packTreeNode.pos-left+1;
                }
            }
        }
        return res;
    }

    int res;
    Map<Integer,Integer> map;

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root) {
        res = 0;
        map = new HashMap<>();
        dfs(root,0,0);
        return res;
    }

    public void dfs(TreeNode root,int level,int pos){
        if(root == null) return;
        map.putIfAbsent(level,pos);
        res = Math.max(res,pos-map.get(level)+1);
        dfs(root.left,level+1,2*pos);
        dfs(root.right,level+1,2*pos+1);
    }
}
