class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<Integer>();
        this.k = k;
        for(int num : nums){
            add(num);
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.add(val);
        }else if(minHeap.peek() < val){
            minHeap.poll();
            minHeap.add(val);
        }
        
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */