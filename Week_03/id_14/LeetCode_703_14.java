import java.util.*;

/**
 * https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/
 * <p>
 * 第K大元素
 *
 * <p> 简单
 * <p> 堆
 *
 * @author aiter
 * @date 2019/05/03 8:20 PM
 */
public class LeetCode_703_14 {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest3 kthLargest = new KthLargest3(k, arr);
        System.out.println(String.format("添加%d , 期望值：4，实际值：%d", 3, kthLargest.add(3)));   // returns 4
        System.out.println(String.format("添加%d , 期望值：5，实际值：%d", 5, kthLargest.add(5)));   // returns 5
        System.out.println(String.format("添加%d , 期望值：5，实际值：%d", 10, kthLargest.add(10)));  // returns 5
        System.out.println(String.format("添加%d , 期望值：8，实际值：%d", 9, kthLargest.add(9)));   // returns 8
        System.out.println(String.format("添加%d , 期望值：8，实际值：%d", 4, kthLargest.add(4)));   // returns 8
    }

    /**
     * 利用java本身的优先级队列（堆）。一定要注意是只维护top K大小的堆。
     * <pre>
     *     不到k，就直接插入
     *     大于等于k，而且插入元素大于堆顶元素，先删除堆顶，再插入
     * </pre>
     */
    static class KthLargest3 {
        private PriorityQueue<Integer> heap;
        private int topK;

        public KthLargest3(int k, int[] nums) {
            topK = k;
            heap = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (heap.size() < topK) {
                heap.add(val);
            } else if (heap.peek() < val) {
                heap.poll();
                heap.add(val);
            }

            return heap.peek();
        }
    }

    /**
     * 先添加所有的元素，在删除多余top k的数据（这种方式不好）
     */
    static class KthLargest2 {
        private PriorityQueue<Integer> heap;
        private int topK;

        public KthLargest2(int k, int[] nums) {
            topK = k;
            heap = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

            for (int i = 0; i < nums.length; i++) {
                heap.add(nums[i]);
            }

            delete();
        }

        public int add(int val) {

            heap.add(val);
            delete();
            return heap.peek();
        }

        void delete() {
            while (heap.size() > topK) {
                heap.poll();
            }
        }
    }

    /**
     * 自行实现小顶堆。
     * <pre>
     *     如果堆大小还不到 k的大小，最后位置插入元素，并从下到上堆化
     *     如果堆大小已经k的大小。
     *      1. 插入值，小于等于堆顶元素，直接返回堆顶元素
     *      2. 插入值，大于堆顶元素。直接替换堆顶元素，并从上到下堆化（使用java优先队列，这一步需要先删堆顶，再添加元素，2次堆化）
     * </pre>
     */
    static class KthLargest {
        private int k = 0;
        private int size;
        private int[] items;

        //nums 的长度≥ k-1 且k ≥ 1。
        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.items = new int[k];
            for (int i = 0; i < nums.length; i++) {
                add(nums[i]);
            }
        }

        public int add(int val) {
            if (size >= k) {
                if (items[0] < val) {
                    items[0] = val;
                    siftDown(items, size, 0);
                }
                return items[0];
            } else {
                items[size++] = val;

                siftup(size - 1, items[size - 1]);

                return items[0];
            }
        }

        void printArray(int arr[]) {
            int n = arr.length;
            for (int i = 0; i < n; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }

        /**
         * 从下往上堆化(小顶堆)
         *
         * @param t   下标值
         * @param key 下标元素值
         */
        void siftup(int t, int key) {
            while (t > 0) {
                int parent = (t - 1) >>> 1;
                //System.out.println(t + ":" + key + ":" + parent);
                int e = items[parent];
                if (e <= key) { break; }
                items[t] = e;
                t = parent;
            }
            items[t] = key;
        }

        /**
         * 从上往下堆化(小顶堆)
         *
         * @param arr 数组
         * @param n   数组大小
         * @param i   下标值
         */
        void siftDown(int arr[], int n, int i) {
            // 初始化i为最小值
            int smallest = i;
            // 左节点 = 2*i + 1
            int l = 2 * i + 1;
            // 右节点 = 2*i + 2
            int r = 2 * i + 2;

            // 左节点比当前节点小
            if (l < n && arr[l] < arr[smallest]) { smallest = l; }

            // 右节点更小
            if (r < n && arr[r] < arr[smallest]) { smallest = r; }

            // 如果，最小值不是当前节点(左、右)，就交换。并继续堆化
            if (smallest != i) {
                int swap = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = swap;

                // Recursively heapify the affected sub-tree
                siftDown(arr, n, smallest);
            }
        }
    }

}

