package com.imooc.activiti.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author shironghui on 2019/4/18.
 */


class Solution6 {
    //Hash table that takes care of the mappings
    private HashMap<Character,Character> mappings;
    //Initialize hash map with mappings.this simply makes the code easier to read.
    public Solution6(){
        this.mappings=new HashMap<Character,Character>();
        this.mappings.put(')','(');
        this.mappings.put('}','{');
        this.mappings.put(']','[');
    }
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(mappings.containsKey(ch)){
                char popelement=stack.empty()?'#':stack.pop();
                if(popelement!=mappings.get(ch)){
                    return false;
                }
            }
            else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

public class TestStack2 {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);

            int[] ret =  Solution4.sortArrayByParity2(A);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
