package com.guald.demo;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 *
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 */
public class Demo3 {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        int[] diff = new int[26];
        for(int i=0;i<s1.length();i++){
            diff[s1.charAt(i) - 'a']++;
            diff[s2.charAt(i) - 'a']--;
        }
        for(int i=s1.length();i<s2.length();i++){
            int j=0;
            for(;j<diff.length;j++){
                if(diff[j] != 0) break;
            }
            if(j == diff.length) return true;
            diff[s2.charAt(i-s1.length()) - 'a']++;
            diff[s2.charAt(i) - 'a']--;
        }
        int j=0;
        for(;j<diff.length;j++){
            if(diff[j] != 0) break;
        }
        if(j == diff.length) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab","eidbaooo"));
    }
}
