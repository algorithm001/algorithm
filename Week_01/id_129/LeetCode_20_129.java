import java.util.Stack;

public class LeetCode_20_129 {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else if (')' == c || ']' == c || '}' == c) {
                if (stack.empty()) {
                    return false;
                }
                char e = stack.pop();
                if (!isSame(e, c)) {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isSame(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
}
