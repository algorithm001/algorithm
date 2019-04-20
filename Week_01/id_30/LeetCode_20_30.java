package com.shufeng.algorithm.d0_;

/**
 * @author gsf
 */
public class LeetCode_22_30 {

    public static void main(String[] args) {
        String str = "(]";
        System.out.println(isValid(str));

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c == ')' && pop != '(') {
                    return false;
                }
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
    // 虽然慢，面试让我说就说栈，让我写，写这个嘿嘿。
    public boolean isValid1(String s) {
        while (s.length() != 0) {
            int length = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
            if (length == s.length()) {
                return false;
            }
        }
        return true;
    }
}
