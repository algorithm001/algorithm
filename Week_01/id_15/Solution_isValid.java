package com.haotone.week_01;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        
        if(s == null || "".equals(s)) return true;
        char[] charArray = s.toCharArray();
        Stack sta = new Stack();
        for(char a:charArray){

            if(sta.isEmpty()){
                sta.push(a);
                continue;
            } 
            char peek = (char)sta.peek();
            if((peek=='(' && a==')')
                    || (peek=='[' && a==']')
                    || (peek=='{' && a=='}'))
                sta.pop();
            else 
                sta.push(a);
        }
        if(sta.isEmpty()) return true;
        else return false;
        
    }
}