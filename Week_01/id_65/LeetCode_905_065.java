package com.imooc.activiti.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shironghui on 2019/4/18.
 */


class Solution3 {
    public static int[] sortArrayByParity(int[] A) {
        int length=A.length;
        int[] B=new int[length];
        int[] C=new int[length];
        int j=0;
        int l=0;
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
        int o=0;
        for(int k=j;k<B.length;k++){
            B[k]=C[o];
            o++;
        }
        return B;
    }
}

public class TestArray {
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

            int[] ret =  Solution3.sortArrayByParity(A);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}
