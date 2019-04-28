package com.imooc.activiti.helloworld;

import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author shironghui on 2019/4/18.
 */

//排序解法
class Solution8 {
    public boolean isAnagram(String s, String t) {
       if(s.length()!=t.length()){
           return false;
       }
       char[] sChars=s.toCharArray();
       char[] tChars=t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars,tChars);
    }
}
//hash表解法
class Solution9 {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] count=new int[26];
        char[] sChars=s.toCharArray();
        char[] tChars=t.toCharArray();
        for(int i=0;i<sChars.length;i++){
            count[sChars[i]-'a']++;
            count[tChars[i]-'a']--;
        }
        for (int i=0;i<count.length;i++){
            if(count[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}

public class TestChar1 {
    public static String stringToString(String input) {
        return JsonArray.readFrom("[" + input + "]").get(0).asString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String t = stringToString(line);

            boolean ret = new Solution8().isAnagram(s, t);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
