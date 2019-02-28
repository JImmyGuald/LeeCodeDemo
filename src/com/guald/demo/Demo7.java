package com.guald.demo;

import java.util.ArrayList;
import java.util.List;

public class Demo7 {
    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length()>12) return res;
        for(int i=0;i<s.length()-3;i++){
            String first = s.substring(0,i+1);
            if((first.length()>1 && first.startsWith("0")) || Integer.valueOf(first)>255) continue;
            for(int j=i+1;j<s.length()-2;j++){
                String second = s.substring(i+1,j+1);
                if((second.length()>1 && second.startsWith("0")) || Integer.valueOf(second)>255) continue;
                for(int k=j+1;k<s.length()-1;k++){
                    String third = s.substring(j+1,k+1);
                    String forth = s.substring(k+1,s.length());
                    if((third.length()>1 && third.startsWith("0")) || Integer.valueOf(third)>255) continue;
                    if((forth.length()>1 && forth.startsWith("0")) || Integer.valueOf(forth)>255) continue;
                    res.add(first+"."+second+"."+third+"."+forth);
                }
            }
        }
        return res;
    }

    /**
     * 溯源法
     */
    public static List<String> restoreIpAddresses2(String s){
        List<String> res = new ArrayList<>();
        if(s.length()<4 || s.length()>12) return res;
        sy(res,"",s,0,0);
        return res;
    }

    public static void sy(List<String> res,String item,String s,int part,int st){
        if(part>4) return;
        if(part == 4 && st == s.length()){
            res.add(item);
            return;
        }
        if(st >= s.length()) return;
        if(s.charAt(st) == '0'){
            sy(res,item + (part == 3 ? 0 : 0+"."),s,part+1,st+1);
            return;
        }
        for(int i=st+1;i<=s.length()&&i<=st+3;i++){
            if(Integer.valueOf(s.substring(st,i))>255) return;
            sy(res,item + s.substring(st,i) + (part == 3 ? "" : "."),s,part+1,i);
        }
    }

    public static void main(String[] args) {
       List<String> res = restoreIpAddresses2("010010");
       res.forEach(n-> System.out.println(n));
    }
}
