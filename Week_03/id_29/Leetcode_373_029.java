package leetcode.Algorithms._301_400._373_FindKPairsWithSmallestSums;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by jialei.zou on 2019/5/5 .
 * ref:
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/

 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。

 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。

 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。

 示例 1:

 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 输出: [1,2],[1,4],[1,6]
 解释: 返回序列中的前 3 对数：
 [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 示例 2:

 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 输出: [1,1],[1,1]
 解释: 返回序列中的前 2 对数：
 [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 示例 3:

 输入: nums1 = [1,2], nums2 = [3], k = 3
 输出: [1,3],[2,3]
 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]

 https://leetcode.com/problems/find-k-pairs-with-smallest-sums/submissions/
 *
 */
public class FindKPairsWithSmallestSums {

    /**
     * 后续看下官方其他人的解答
     * 63 ms, faster than 10.02%   37.4 MB, less than 97.04%
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new LinkedList<>();
        if((nums1 == null || nums1.length == 0)||(nums2 == null || nums2.length == 0) || k<1){
            return result;
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(
                (int[] a, int[] b)-> sum(b)-sum(a)
        );

        for (int i=0; i<nums1.length; i++){
            for (int j=0; j<nums2.length; j++){
                if(priorityQueue.size()<k){
                    priorityQueue.offer(new int[]{nums1[i],nums2[j]});
                }else { //==k
                    if(sum(priorityQueue.peek()) >= nums1[i]+nums2[j]){
                        priorityQueue.poll();
                        priorityQueue.offer(new int[]{nums1[i],nums2[j]});
                    }
                }
            }
        }

        while (!priorityQueue.isEmpty()){
            result.add(priorityQueue.poll());
        }

        Collections.reverse(result);

        return result;
    }

    private int sum(int[] a){
        int sum = 0;
        for (int item: a){
            sum = sum + item;
        }
        return sum;
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums sums = new FindKPairsWithSmallestSums();
        List<int[]> result1 = sums.kSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3);
        List<int[]> result2 = sums.kSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2);
        List<int[]> result3 = sums.kSmallestPairs(new int[]{1,2}, new int[]{3}, 3);
        System.out.println("end here");

    }
}
