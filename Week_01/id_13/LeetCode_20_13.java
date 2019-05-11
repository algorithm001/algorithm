package leetCode;

import java.util.Stack;

public class LeetCode_20_13 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(ch);
            } else if (isMatch(stack.peek(), ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.empty();
    }

    private boolean isMatch(char ch1, char ch2) {
        return ((ch1 == '{' && ch2 == '}')
                || ch1 == '[' && ch2 == ']'
                || ch1 == '(' && ch2 == ')');
    }
}
