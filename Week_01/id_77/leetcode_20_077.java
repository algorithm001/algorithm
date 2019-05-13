class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length() == 0){
            return true;
        }
        boolean flag = true;
        char ch;
        for(int i=0;i<s.length();i++){
            ch = s.charAt(i);
             try {
             if (ch == ')') {
                if ('('==stack.pop()) {
                    continue;
                } else {
                    return false;
                }
            } else if (ch==']') {
                if ('['==stack.pop()) {
                    continue;
                } else {
                   return false;
                }
            } else if (ch =='}') {
                if ('{'==stack.pop()) {
                    continue;
                } else {
                   return false;
                }
            }else{
               stack.push(ch); 
            }
            } catch (Exception e) {
               return false;
            }      
            
        }

        if(stack.size()>0){
            return false;
        }else {
            return flag;
        }
    }
}