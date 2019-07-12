import java.util.PriorityQueue;

public class Leetcode703_143 {

    class KthLargest {

        private int k;

        private PriorityQueue<Integer> queue;

        public KthLargest(int k, int[] nums) {
            this.k=k;
            queue=new PriorityQueue<>(k);
            for(int i=0;i<k;i++){
                add(nums[i]);
            }

        }

        public int add(int val) {
            if(queue.size()<k){
                queue.offer(val);
            }else if(queue.peek()<val){
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }
    }
}
