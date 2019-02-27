package com.guald.demo;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例 1：
 *
 * 输入： num1 = “2”, num2 = “3”
 * 输出： “6”
 *
 * 示例 2：
 *
 * 输入： num1 = “123”, num2 = “456”
 * 输出： “56088”
 *
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger） 或 直接将输入转换为整数来处理。
 */
public class Demo4 {
    public static String multiply(String num1, String num2) {
        int[] num = new int[num1.length()+num2.length()];
        for(int i=num1.length()-1;i>=0;i--){
            for(int j=num2.length()-1;j>=0;j--){
                num[i+j+1] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        int flag = 0;
        for(int i=num.length-1;i>=0;i--){
            num[i] += flag;
            flag = num[i]/10;
            num[i] %= 10;
        }
        StringBuffer res = new StringBuffer();
        int index = 0;
        for(int i=0;i<num.length;i++){
            if(num[i]>0) {index = i; break;}
        }
        if(index == 0){
            return "0";
        }
        for(int i=index;i<num.length;i++){
            res.append(String.valueOf(num[i]));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("123","456"));
    }
}
