class KthLargest {

    private PriorityQueue<Integer> queue;

    private int k;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (queue.size() < k) {
            queue.add(val);
            return queue.peek();
        }
        if (queue.peek() < val) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }
}