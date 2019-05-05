//https://leetcode.com/problems/kth-largest-element-in-a-stream/
class KthLargest {
    
    private PriorityQueue<Integer> queue;
    private int ksize;

    public KthLargest(int k, int[] nums) {
        if (nums != null && k > 0) {
            ksize = k;
            queue  = new PriorityQueue<>();
            for (int n : nums) {
                add(n);
            }
        }
    }
    
    public int add(int val) {
        if (queue == null)
            return 0;
        if (queue.size() < ksize) {
            queue.offer(val);
        } else {
            if (queue.peek() < val) {
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
