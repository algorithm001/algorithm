package com.v0ex.leetcode;

import java.util.PriorityQueue;

/**
 * @author bugcoder
 */
public class LeetCode_703_49 {

    /**
     * 使用小顶堆
     */
    final PriorityQueue<Integer> q;

    final int k;

    public LeetCode_703_49(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        //初始化小顶堆
        for (int val : nums){
            add(val);
        }
    }

    public int add(int val){
        if (q.size() < k){
            q.offer(val);
        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
