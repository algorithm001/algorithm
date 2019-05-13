class Solution {
    
    private static HashMap<Character, Character> mapping = new HashMap<>();
    static {
        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
            
        for (char c : s.toCharArray()) {
            if (mapping.containsKey(c)) {
                if (stack.empty()) {
                    return false;
                }
                char left = stack.pop();
                if (mapping.get(c) == left) {
                    continue;
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        } 

        return stack.empty();
        
    }
}