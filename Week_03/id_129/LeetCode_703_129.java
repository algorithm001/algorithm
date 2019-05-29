import java.util.PriorityQueue;

public class LeetCode_703_129 {
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int size;

    public LeetCode_703_129(int k, int[] nums) {
        KthLargest(k, nums);
    }

    public void KthLargest(int k, int[] nums) {
        this.size = k;
        for (int n : nums) add(n);
    }

    public int add(int val) {
        if (minHeap.size() < size) minHeap.offer(val);
        else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

}
