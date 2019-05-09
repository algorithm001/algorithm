package com.fanlu.leetcode.heap;

import java.util.PriorityQueue;

// Source : https://leetcode.com/problems/kth-largest-element-in-a-stream/
// Id     : 703
// Author : Fanlu Hai
// Date   : 2018-05-05
// Other  : should implement priority queue manually
// Tips   :


public class KthLargest {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int size;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for (int n : nums) {
            add(n);
        }
    }

    //99.55% 64.02%
    public int add(int val) {
        if (minHeap.size() < size)
            minHeap.offer(val);
        else if (minHeap.peek() < val) {
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */