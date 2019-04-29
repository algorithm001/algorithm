class Solution {
    static   HashMap<Character, Character> dic = new HashMap<>(3);
    static {
        dic.put('(',')');
        dic.put('[',']');
        dic.put('{','}');
    }
    public  boolean isValid(String s) {
        if(s == null){
            return false;
        }
        if(s.equals("")){
            return true;
        }
        Stack stack=new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0;i < chars.length;i ++) {
            char c = chars[i];
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if(c == ')' || c == ']' || c == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                char pop = (Character)stack.pop();
                Character right = dic.get(pop);
                if(right == c ){
                    if(stack.isEmpty() && i == chars.length -1){
                        return true;
                    }
                    continue;
                }
                return false;
            }
        }
        return false;
    }
}