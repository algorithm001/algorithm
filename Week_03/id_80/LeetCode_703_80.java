class KthLargest {

    // 用的是优先队列，一直维护一个长度为k的队列，add时候如果长度不够k，添加就好，
   // 长度大于k时候，判断加入这个数和队列中最小的数比较就ok
   
       final PriorityQueue<Integer> q ;
       final int k ;
       public KthLargest(int k, int[] nums) {
           this.k = k ;
           q = new PriorityQueue<>(k);
           for(int i : nums ){
               add(i);
           }
       }
       
       public int add(int n) {
           // 返回第K大的数字
           if(q.size() < k ){
               q.offer(n);
           }else if(q.peek() < n) {
               q.poll();
               q.offer(n);
           }
           return q.peek();
       }
   
   }
   
   /**
    * Your KthLargest object will be instantiated and called as such:
    * KthLargest obj = new KthLargest(k, nums);
    * int param_1 = obj.add(val);
    */