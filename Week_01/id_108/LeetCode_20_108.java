import org.junit.Test;

import java.util.Stack;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/04/29
 */
public class LeetCode_20_108 {
        public static void main(String[] args) {
            String str = "()[]{}";
            System.out.println(isValid(str));
        }
        public  static boolean isValid(String s) {
            Stack stack = new Stack();
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(stack.peek().equals(anotherChar(c))){
                    stack.pop();
                }else{
                    stack.push(c);
                }
            }
            return stack.isEmpty();
        }

        private static char anotherChar(char c){
            if(c == '('){
                return ')';
            }
            if(c == ')'){
                return '(';
            }
            if(c == '{'){
                return '}';
            }
            if(c == '}'){
                return '{';
            }
            if(c == '['){
                return ']';
            }
            if(c == ']'){
                return '[';
            }
            return '0';
        }
}
