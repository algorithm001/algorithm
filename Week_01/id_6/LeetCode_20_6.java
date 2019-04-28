


	// 利用栈实现括号匹配检查
    // 左括号入栈，右括号出栈
	public boolean isValid2(String s) {
        if (s.length() == 0){
            return true;
        }

        if (s.length() == 1){
            return false;
        }

        Stack stack = new Stack();

        char c = '0';
        char d = '0';

        // 遍历str
        for (int i = 0; i < s.length() ; i++) {
            c = s.charAt(i);
            if (c=='(' || c=='{' || c=='['){
				// 入栈时，压入对应的右括号，减少出栈时比对的复杂度
                if (c == '('){
                    stack.push(')');
                }else if (c == '{'){
                    stack.push('}');
                }else {
                    stack.push(']');
                }
            }

            if (c==')' || c=='}' || c==']'){
                if (stack.isEmpty()){
                    return false;
                }

                d = (char)stack.pop();
                if (c != d){
                    return false;
                }
            }
        }
        // 栈应该是空
        if (!stack.empty()){
            return false;
        }

        return true;
    }