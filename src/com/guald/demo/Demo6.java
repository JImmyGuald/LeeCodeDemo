package com.guald.demo;

import java.util.LinkedList;
import java.util.List;

public class Demo6 {
    public static String simplifyPath(String path) {
        LinkedList<String> container = new LinkedList<>();
        String[] strs = path.split("/");
        StringBuilder res = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            if("..".equals(strs[i])){
                if(!container.isEmpty()) {
                    container.removeLast();
                }
            }else if(".".equals(strs[i]) || "".equals(strs[i])){
                continue;
            }else{
                container.addLast("/" + strs[i]);
            }
        }
        if(container.isEmpty()){
            return "/";
        }else{
            container.forEach(n->res.append(n));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/a//b////c/d//././/.."));
    }
}
