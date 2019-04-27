import java.util.Deque;
import java.util.ArrayDeque;

class Solution {

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        boolean ret = false;
        Deque<Character> stack = new ArrayDeque<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.addFirst(c);
            } else {
                if (stack.isEmpty()) {
                    break;
                }
                char p = stack.removeFirst();
                if (!(c == ')' && p == '(')
                    && !(c == ']' && p == '[')
                    && !(c == '}' && p == '{')) {
                    break;
                }
                if (i == s.length() - 1 && stack.isEmpty()) {
                    ret = true;
                }
            }

        }
        return ret;
    }
}