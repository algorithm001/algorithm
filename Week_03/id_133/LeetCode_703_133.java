class KthLargest {
    //小顶堆
    private Queue<Integer> littleHeap ;
    //携带需要的K大数
    private int k ;

    public KthLargest(int k, int[] nums) {
        //这里使用PriorityQueue  且只保留前K个元素即可
        littleHeap = new PriorityQueue<>(k);
        this.k = k ;
        for(int i : nums){
            add(i);
        }
    }
    
    //调用add方法，判断队列是否满了，如果满了判断最小值和val比较，如果val大弹出最小，添加val
    public int add(int val) {
        if(littleHeap.size() < k){
            littleHeap.add(val);
        }else{
            if(val>littleHeap.peek()){
                littleHeap.poll();
                littleHeap.add(val);
            }
        }
        return littleHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
