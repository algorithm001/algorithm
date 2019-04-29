/**
 * 
 */
class LeetCode_20_95 {
    public boolean isValid(String s) {
       //建立栈对象,用于char类型入栈
        Stack<Character> stack = new Stack<Character>();
        
        //遍历字符串
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(')');//压栈
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else if(stack.isEmpty() || stack.pop()!=c){//stack.pop()!=c
                return false;
            }
            
        }
        return true;
        
    }
}