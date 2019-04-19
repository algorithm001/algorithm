package com.imooc.activiti.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shironghui on 2019/4/18.
 */


class Solution4 {
    public static int[] sortArrayByParity2(int[] A) {
        int length=A.length;
        int[] B=new int[length/2];
        int[] C=new int[length/2];
        int[] D=new int[length];
        int j=0;
        int l=0;
        int f=0;
        int g=0;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                B[j]=A[i];
                j++;
            }
            else {
                C[l]=A[i];
                l++;
            }
        }
        for(int o=0;o<length;o++){
            if(o%2==0){
                D[o]=B[f];
                f++;
            }
            else {
                D[o]=C[g];
                g++;
            }
        }
        return D;
    }
}

public class TestArray2 {
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
