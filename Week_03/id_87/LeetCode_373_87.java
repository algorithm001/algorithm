
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    
    /**
     * Medium
     * 373. Find K Pairs with Smallest Sums
     * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
     *
     * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
     *
     * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
     *
     * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
     *
     * Example 1:
     * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * Output: [[1,2],[1,4],[1,6]]
     * Explanation: The first 3 pairs are returned from the sequence:
     *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     *
     * Example 2:
     * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
     * Output: [1,1],[1,1]
     * Explanation: The first 2 pairs are returned from the sequence:
     *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     *
     *
     * Example 3:
     * Input: nums1 = [1,2], nums2 = [3], k = 3
     * Output: [1,3],[2,3]
     * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
     *
     * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/discuss/84551/simple-Java-O(KlogK)-solution-with-explanation
     *
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 第一个数组横排，第二个数组竖派，组成matrix
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)->a[0]+a[1]-b[0]-b[1]); // comparator
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res; // break condition
        for(int i=0; i<nums1.length && i<k; i++) {
            que.offer(new int[]{nums1[i], nums2[0], 0}); //默认将第一行加入队列，不需要排序，已经有序
        }

        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) {
                //没有下一列了
                continue;
            }
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});//将下一行的第一列放入队列，自动排序
        }
        return res;
    }
}