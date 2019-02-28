package com.guald.demo;

public class Demo5 {

    public static String reverseWords(String s) {
        StringBuffer res = new StringBuffer();
        if(s!=null) {
            String[] strs = s.split(" ");
            for(int i=strs.length-1;i>=0;i--){
                if(!"".equals(strs[i])){
                    res.append(strs[i]+" ");
                }
            }
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }
}
