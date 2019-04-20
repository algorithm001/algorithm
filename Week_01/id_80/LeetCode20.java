/**
 * 
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
class Solution {
    private HashMap<Character, Character> mappings;
    public Solution(){
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put('(', ')');
    this.mappings.put('{', '}');
    this.mappings.put('[', ']');
   
    }
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(stack.size()==0){
                stack.push(c);
            }else if(isSym(stack.peek(),c)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
    
    private boolean isSym(char c1, char c2) {
        if(mappings.containsKey(c1)){
            if(mappings.get(c1)!=c2){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }
}