import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/05
 */
public class LeetCode_703_108 {


    //方法1
    class KthLargest {

        private PriorityQueue<Integer> maxHeap = null;
        private PriorityQueue<Integer> minHeap = null;
        int maxHeapCount = 0;

        /**
         * 维护两个堆，大顶堆和小顶堆，小顶堆只存储k个数据，小顶堆的每个元素都大于大顶堆
         * 放入数据时判断，如果小于小顶堆的堆顶元素，则将堆顶放入小顶堆，调整小顶堆，否则放入大顶堆
         *
         * @param k
         * @param nums
         */
        public KthLargest(int k, int[] nums) {
            maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
            minHeap = new PriorityQueue<>();
            maxHeapCount = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < maxHeapCount) {
                minHeap.offer(val);
                return -1;
            } else if (minHeap.size() == maxHeapCount) {
                if (minHeap.peek() >= val) {
                    maxHeap.offer(val);
                } else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(val);
                }
            }
            return minHeap.peek();
        }
    }


    //方法2
    class KthLargest {

        private PriorityQueue<Integer> minHeap = null;
        int maxHeapCount = 0;

        /**
         * 只维护小顶堆就可以，小顶堆只存储k个数据
         * 放入数据时判断，如果小于小顶堆的堆顶元素，则删除堆顶元素，同时将元素放入小顶堆，调整小顶堆
         *
         * @param k
         * @param nums
         */
        public KthLargest(int k, int[] nums) {
            minHeap = new PriorityQueue<>();
            maxHeapCount = k;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            if (minHeap.size() < maxHeapCount) {
                minHeap.offer(val);
            } else if (minHeap.size() == maxHeapCount) {
                if (minHeap.peek() < val) {
                    minHeap.poll();
                    minHeap.offer(val);
                }
            }
            return minHeap.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
