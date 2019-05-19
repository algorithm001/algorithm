package data.leetcode.dui;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//leetcode703
public class leetcode703 {

    /**
     * 设计一个找到数据流中第K大元素的类（class）。
     * 注意是排序后的第K大元素，不是第K个不同的元素。
     * <p>
     * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。每次调用 KthLargest.add，返回当前数据流中第K大的元素。
     */
    private List<Integer> data = new ArrayList<>();

    final int k;

    /**
     * 解法1
     *
     * @param k
     * @param nums
     */
    public leetcode703(int k, int[] nums) {
        this.k = k;
        if (nums.length > k) {
            for (int i = 0; i < k; i++) {
                //[[1,[]],[-3],[-2],[-4],[0],[4]]
                data.add(nums[i]);
            }
            heapFc();
            while (k < nums.length - 1) {
                add(nums[k]);
                k++;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                data.add(nums[i]);
            }
            heapFc();
        }

    }

    /**
     * 进行堆化
     */
    public void heapFc() {
        int index = data.size() - 1;
        int rootIndex;
        while (index > 0) {
            if ((index & 1) == 1) {  //#奇数代表为做左节点
                rootIndex = (index / 2);
                if (data.get(rootIndex) > data.get(index)) {
                    int rootValue = data.get(rootIndex);
                    int indexValue = data.get(index);
                    data.set(rootIndex, indexValue);
                    data.set(index, rootValue);
                }
            } else {  //偶数数代表为做右边节点
                rootIndex = (index / 2) - 1;
                int leftindex = index - 1;
                if (data.get(rootIndex) > data.get(leftindex)) {
                    if (data.get(leftindex) > data.get(index)) {
                        int rootValue = data.get(rootIndex);
                        int indexValue = data.get(index);
                        data.set(rootIndex, indexValue);
                        data.set(index, rootValue);
                    } else {
                        int rootValue = data.get(rootIndex);
                        int indexValue = data.get(leftindex);
                        data.set(rootIndex, indexValue);
                        data.set(index, rootValue);
                    }
                } else if (data.get(rootIndex) > data.get(index)) {
                    int rootValue = data.get(rootIndex);
                    int indexValue = data.get(index);
                    data.set(rootIndex, indexValue);
                    data.set(index, rootValue);
                }
            }
            index = rootIndex;
        }
    }

    public int add(int val) {
        if (data.size() < k) {
            data.add(val);
            heapFc();
        } else {
            if (data.get(0) < val) {
                data.set(0, val);
                heapFc();
            }
        }
        return data.get(0);
    }


    public static void main(String[] args) {
        /**
         * ["KthLargest","add","add","add","add","add"]
         * [[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
         */
        /**
         * ["KthLargest","add","add","add","add","add"]
         * [[3,[4,5,8,2]],[3],[5],[10],[9],[4]]
         */
        int nums[] = {3, 5, 2, 3, 5, 10, 9, 4};
        leetcode703 leetcode703 = new leetcode703(4, nums);
        System.out.println(leetcode703.data.get(0));
    }


    /**
     * 解法2
     */

    PriorityQueue<Integer> q = null;

    public leetcode703(int k, int[] nums, int test) {
        this.k = k;
        q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            add(i);
        }
    }

    public int add1(int val) {
        if (q.size() < k) {
            q.offer(val);

        } else if (q.peek() < val) {
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
