class LeetCode_784_95 {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        String temp = "";
        letter(list,S,temp,0);
        return list;
    }
    
    public static void letter(List<String> list,String S, String temp , int index){
 
        if (S.length() == temp.length()) list.add(temp);
        
        if (index == S.length()) return;
 
        temp+=S.charAt(index);
        letter(list,S,temp,index+1);
        temp = temp.substring(0,temp.length()-1);
        
        if (S.charAt(index) >= 'a' && S.charAt(index) <= 'z'){//小写字母a-z
            temp += (char)(S.charAt(index) + 'A' - 'a');
            letter(list,S,temp,index+1);
         }else if(S.charAt(index) >= 'A' && S.charAt(index) <= 'Z'){//大写字母A-Z
            temp += (char)(S.charAt(index) + 'a' - 'A');
            letter(list,S,temp,index+1);
        }
        
    }
}