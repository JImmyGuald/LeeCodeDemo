package com.guald.demo;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jayden.gan
 * @description
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * @create 2020/4/20 16:18
 */
public class LC200420 {
    //dfs
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int result = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>=grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }

    //bfs
    public int bfs(char[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int result = 0;
        for(int i = 0;i<grid.length;i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1'){
                    grid[i][j] = '0';
                    result++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i*grid[0].length+j);
                    while(!queue.isEmpty()){
                        int data = queue.remove();
                        int m = data/grid[0].length;
                        int n = data%grid[0].length;
                        if(m>0 && grid[m-1][n] == '1'){
                            queue.add((m-1)*grid[0].length+n);
                            grid[m-1][n] = '0';
                        }
                        if(n>0 && grid[m][n-1] == '1'){
                            queue.add(m*grid[0].length+n-1);
                            grid[m][n-1] = '0';
                        }
                        if(m<grid.length-1 && grid[m+1][n] == '1'){
                            queue.add((m+1)*grid[0].length+n);
                            grid[m+1][n] = '0';
                        }
                        if(n<grid[0].length-1 && grid[m][n+1] == '1'){
                            queue.add(m*grid[0].length+n+1);
                            grid[m][n+1] = '0';
                        }
                    }
                }
            }
        }
        return result;
    }

    //并查集
}
