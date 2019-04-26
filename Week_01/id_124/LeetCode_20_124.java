import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValidBrackets {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        char[] cArr = s.toCharArray();
        for (char c : cArr) {
            if (stack.isEmpty()){
                stack.push(c);
                continue;
            }
            char topc = stack.peek();
            if (brackets.containsKey(c) && topc == brackets.get(c)) {
                stack.pop();
            }else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValidBrackets brackets = new IsValidBrackets();
        System.out.println(brackets.isValid("()]"));

    }
}
