import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LeetCode20 {

    public boolean isValid(String s) {
        Map<Character,Character> mappings=new HashMap<>();
        mappings.put('(',')');
        mappings.put('{','}');
        mappings.put('[',']');

        Stack<Character> stack=new Stack<Character>();
        int length=s.length();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(mappings.containsKey(c)){
                if(stack.empty()||stack.pop()!=mappings.get(c))
                    return false;
            }else{
                stack.push(c);
            }
        }

        return stack.empty();
    }
}
