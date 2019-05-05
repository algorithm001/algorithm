package algorithm.Week_03.id_58;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 *
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 *
 * Example:
 *
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 *
 *
 * 分析：这里主要考的是最小堆的用法
 *               3
 *             /  \
 *            5   7
 *
 * 先维护一个k个元素的最小堆
 * 依次插入后续元素
 * 比较新加的元素和堆顶的元素，若比堆顶元素小，则丢弃；若大，则插入
 *
 * @auther: guangjun.ma
 * @date: 2019/5/5 20:35
 * @version: 1.0
 */
public class LeetCode_703_058 {
    //定义k个元素
    final int k ;
    //声明一个最小堆
    final PriorityQueue<Integer> q ;

    //初始化 k q
    public LeetCode_703_058(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for(int i : nums){
            add(i);
        }
    }

    //新增方法
    // 比较新加的元素和堆顶的元素，若比堆顶元素小，则丢弃；若大，则插入
    public int add(int val) {
        if(q.size() < k){
            q.offer(val);
        }else if(q.peek() < val){
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }

}
