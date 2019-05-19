package data.leetcode.dui;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode373 {
    /**
     * 给定两个以升序排列的整形数组 nums1 和 nums2, 以及一个整数 k。
     *
     * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2。
     *
     * 找到和最小的 k 对数字 (u1,v1), (u2,v2) ... (uk,vk)。
     */
    /**
     * 示例 1:
     * <p>
     * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
     * 输出: [1,2],[1,4],[1,6]
     * 解释: 返回序列中的前 3 对数：
     * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
     * 示例 2:
     * <p>
     * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
     * 输出: [1,1],[1,1]
     * 解释: 返回序列中的前 2 对数：
     * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
     * 示例 3:
     * <p>
     * 输入: nums1 = [1,2], nums2 = [3], k = 3
     * 输出: [1,3],[2,3]
     * 解释: 也可能序列中所有的数对都被返回:[1,3],[2,3]
     */
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0) return new ArrayList<>();
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(k, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value > o2.value) {
                    return -1;
                } else if (o1.value < o2.value) {
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                Node node = new Node(sum, nums1[i], nums2[j]);
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(node);
                } else if (priorityQueue.peek().value > sum) { //倒序     //类似于大顶堆
                    priorityQueue.poll();
                    priorityQueue.offer(node);
                }
            }
        }
        List<int[]> result = new ArrayList<>();
        while (result.size() == k && priorityQueue.size() != 0) {
            result.add(0, priorityQueue.poll().nums);
        }

        return result;
    }

    /**
     * 执行用时 : 86 ms, 在Find K Pairs with Smallest Sums的Java提交中击败了26.63% 的用户
     * 内存消耗 : 50 MB, 在Find K Pairs with Smallest Sums的Java提交中击败了38.67% 的用户
     * 进行下一个挑战：
     *
     * @param args
     */
    public static void main(String[] args) {
        //[1,1,2]
        //[1,2,3]
        int num1[] = {1, 1, 2};
        int num2[] = {1, 2, 3};
        leetcode373 leetcode373 = new leetcode373();
        leetcode373.kSmallestPairs(num1, num2, 10);
    }


    class Node {
        public int[] nums;
        public int value;

        public Node(int value, int num1, int num2) {
            this.value = value;
            this.nums = new int[]{num1, num2};
        }
    }


    /**
     * 执行用时 : 30 ms, 在Find K Pairs with Smallest Sums的Java提交中击败了74.56% 的用户
     * 内存消耗 : 43.1 MB, 在Find K Pairs with Smallest Sums的Java提交中击败了77.33% 的用户
     *    PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
     *             @Override
     *             public int compare(int[] o1, int[] o2) {
     *                 return o2[0]+o2[1]-o1[0]-o1[1];
     *             }
     *         });
     *         for (int i:nums1)
     *         {
     *             for (int j:nums2)
     *             {
     *                 if(queue.size()<k)queue.add(new int[]{i,j});
     *                 else
     *                 {
     *                     int[] t=queue.peek();
     *                     if(i+j<t[0]+t[1])
     *                     {
     *                         queue.poll();
     *                         queue.add(new int[]{i,j});
     *                     }
     *                 }
     *             }
     *         }
     *         ArrayList<int[]> res = new ArrayList<>(k);
     *         res.addAll(queue);
     *         return res;
     */
}
