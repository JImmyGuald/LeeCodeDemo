package com.guald.demo;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class Demo2 {
    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        if(strs.length>1){
            for(int i=0;i<strs[0].length();i++){
                int j = 1;
                for(; j<strs.length; j++){
                    if(strs[j].length()>=i+1){
                        if(strs[j].charAt(i) != strs[0].charAt(i)){
                            break;
                        }
                    }else{
                        break;
                    }
                }
                if(j == strs.length){
                    res = res + strs[0].charAt(i);
                }else{
                    break;
                }
            }
        }else if(strs.length == 1){
            return strs[0];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = new String[2];
        strs1[0] = "aa";
        strs1[1] = "a";
        System.out.println(longestCommonPrefix(strs1));
    }
}
