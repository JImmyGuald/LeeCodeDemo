package com.guald.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Demo1 {
    //暴力法
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s != null && !"".equals(s)) {
            res = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    List<Character> list = new ArrayList<>();
                    int k = i;
                    for (; k <= j; k++) {
                        if (list.contains(s.charAt(k))) {
                            break;
                        } else {
                            list.add(s.charAt(k));
                        }
                    }
                    if (k == j + 1) {
                        if ((j - i + 1) > res) res = j - i + 1;
                    }
                }
            }
        }
        return res;
    }
    //滑动窗口,[i,j)标识i到j中最长的无重复字符字串
    public static int lengthOfLongestSubstring2(String s){
        int res = 0,i = 0,j = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        while(i < n && j < n){
            if(set.contains(s.charAt(j))){
                set.remove(s.charAt(i++));
            }else{
                set.add(s.charAt(j++));
                res = Math.max(j-i,res);
            }
        }
        return res;
    }
    //滑动窗口优化
    public static int lengthOfLongestSubstring3(String s){
        int[] index = new int[128];
        int res = 0,n = s.length();
        for(int i=0,j=0;j<n;j++){
            i = Math.max(index[s.charAt(j)],i);
            res = Math.max(res,j-i+1);
            index[s.charAt(j)] = j+1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring2(" "));
        System.out.println(lengthOfLongestSubstring3("pwwkew"));
    }
}
