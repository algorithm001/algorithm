/**
  * @author apple
  */

public class IsValidByStack {

    /**
     * 利用栈的特性，注意各种边界条件与判空条件
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.equals("") || s == null)
            return true;
        if (s.length() % 2 == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char temp = s.charAt(i);
            if (temp == '(' || temp == '{' || temp == '[')
                stack.push(temp);
            else {
                if (!stack.isEmpty()) {
                    if (temp == ')' && stack.pop() != '(') {
                        return false;
                    }
                    if (temp == ']' && stack.pop() != '[') {
                        return false;
                    }
                    if (temp == '}' && stack.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
