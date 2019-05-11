class KthLargest {

  PriorityQueue<Integer> queue = null;
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k ;
        this.queue = new PriorityQueue<>(k);
        for(int i : nums ){
            add(i);
        }
    }

    public int add(int val) {
        // 如果队列长度小于k，就加入队列
        if(queue.size() < k ){
            queue.offer(val);
        // 如果队列长度等于k，替换队列头部元素
        }else if(queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        // 返回队列头，即第k大元素
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
