class Solution {
    public boolean isValid(String s) {
        if(s==null){
            return true;
        }
        char[] chars= s.toCharArray();
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='{'){
                num1++;
            }
            if(chars[i]=='('){
                num2++;
            }
            if(chars[i]=='['){
                num3++;
            }
            if(chars[i]=='}'){
                num1--;
            }
            if(chars[i]==')'){
                num2--;
            }
            if(chars[i]==']'){
                num3--;
            }
        }
        if(num1!=0||num2!=0||num3!=0){
            return false;
        }
        
        char[] pre= new char[chars.length/2];
        int j=0;
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='{'||chars[i]=='('||chars[i]=='['){
                pre[j]=chars[i];
                j++;
            }
            if(chars[i]=='}'){
                if(pre[j-1]!='{'){
                    return false;
                }
                j--;
            }
            if(chars[i]==')'){
                if(pre[j-1]!='('){
                    return false;
                }
                j--;
            }
            if(chars[i]==']'){
                if(pre[j-1]!='['){
                    return false;
                }
                j--;
            }
        }
        return true;
    }
}
