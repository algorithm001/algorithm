class FreqStack {
    int max;
    Map<Integer, Stack<Integer>> map;
    Map<Integer, Integer> map2;
    public FreqStack() {
        max = 0;
        map=new HashMap();
        map2=new HashMap();
    }
    
    public void push(int x) {
        map2.put(x,map2.getOrDefault(x, 0)+1);
        int xCount=map2.get(x);
        if(max<xCount){
            max=xCount;
        }
        
        if(map.containsKey(xCount)){
           map.get(xCount).push(x);
        }else{
            Stack<Integer> s = new Stack<Integer>();
            s.push(x);
            map.put(xCount,s);
        }
    }
    
    public int pop() {
        int val=map.get(max).pop();
        map2.put(val,map2.get(val)-1);
        if(map.get(max).size()==0){
            max--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
