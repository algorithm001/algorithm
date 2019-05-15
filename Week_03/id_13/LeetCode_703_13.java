package leetCode.week3;

import java.util.*;

/**
 * Kth Largest Element in a Stream
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * @author JP.Jiang
 * @version Java
 * @since 2019/05/01
 */
public class LeetCode_703_13 {

    private final PriorityQueue<Integer> queue;
    private final int k;

    /**
     * 小顶堆其实也是优先队列的一种
     * 使用小顶堆维护第K大的元素
     *
     * @param k 需要反回的项目次序
     * @param nums 输入流
     */
    public LeetCode_703_13(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int val : nums) {
            add(val);
        }
    }

    // 小顶堆
    public int add(int val) {
        if (queue.size() < k) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }

        return queue.peek();
    }

}
