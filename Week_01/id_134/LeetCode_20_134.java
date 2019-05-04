//https://leetcode.com/problems/valid-parentheses/
public class Solution {
   public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
        	if(stack.isEmpty()) {
        		stack.push(s.charAt(i));
        	} else {
        		if(isMatch(stack.peek(), s.charAt(i))) {
        			stack.pop();
        		}
        		else {
        			stack.push(s.charAt(i));
        		}
        	}
        }
        if(stack.isEmpty())
        	return true;
        else
        	return false;
    }
	
	public boolean isMatch(char sc, char c) {
		if(sc=='{'&&c=='}' || sc=='('&&c==')' || sc=='['&&c==']') {
			return true;
		}
		else 
			return false;
	}
}