class Solution {
    
    private Map<Character,Character> charMap=new HashMap();
    public boolean isValid(String s) {
        
        //1.拆成数组
        //2.从头遍历数组 往栈里插入
        //3.记录最后一个入栈的字符 和 当前入栈的字符 比较是否可以消除 
        //  3.1 可以消除 出栈 
        //  3.2 不可以消除 继续入栈 记录当前入栈字符为最后一次入栈字符
        //4.数组遍历结束后 检查栈的长度是否为0 为0则true 否则false
        //  使用栈的数据结构 先入后出
        //3.
        if(s==null){
            return false;
        }
        if("".equals(s)){
            return true;
        }
        initMap(charMap);
     
        Stack stack=new Stack();
        char stackTopStr;
        char str;
        for(int i=0;i<s.length();i++){
            str=s.charAt(i);
            //获取栈顶元素  
            if(stack.empty()){
                //设置默认值
                stackTopStr='#';
            }else{
                stackTopStr=(char)stack.peek(); 
            }
            //比较栈顶元素是否可消除 
            if(canPop(charMap,stackTopStr,str)){
                stack.pop();
            }else{
                //元素入栈
                stack.push(str);
            }
        }
        return stack.empty();
        
    }
    
    /**
    * 初始化map
    **/
    private void initMap(Map<Character,Character> map){
         map.put('(',')');
         map.put('{','}');
         map.put('[',']');
         map.put('"','"');
    }
    
    /**
    *  是否可从栈中移除
    * stackTopStr 栈顶元素
    * waitInStackStr 即将入栈元素
    **/
    private boolean canPop(Map<Character,Character> map,char stackTopStr,char waitInStackStr){
        boolean pop=false;
        Character v=map.get(stackTopStr);
        if(v!=null){
            pop=(v==waitInStackStr);
        }
        return pop;
    }
}