package leetcode.Algorithms._701_800._703_KthLargestElementInAStream;

import algorithm.FrequentlyUsedMethod.Heap;

import java.util.PriorityQueue;

/**
 * Created by jialei.zou on 2019/5/4 .
 * ref: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 */
public class KthLargestElementInAStream {
    private int size = 0;
    private int maxSize;

    private int[] heap;

    public KthLargestElementInAStream(int k, int[] nums) {
        heap = new int[k+1];
        maxSize = k;
        for (int i=0; i<nums.length; i++){
            addItem(nums[i]);
        }
    }
    private void addItem(int val){
        if(size == 0){
            size++;
            heap[1]= val;
        }else if(size>0 && size<maxSize){
            heap[size+1]= val;
            size++;
            int cur = size;
            int parent = cur/2;
            while (true){
                //关键点是要从下向上，依次替换过去
                if(heap[parent]>val){
                    swap(heap, cur, parent);
                    if(parent == 1){
                        break;
                    }
                    cur = parent;
                    parent = parent/2;
                }else {
                    break;
                }
            }
        }else {
            if(val<=heap[1]){
                return;
            }else {
                heap[1] = val;
                int cur = 1;
                int leftChild = cur*2;
                int rightChild = cur*2+1;
                while (true){
                    //如下的条件判断
                    //左右孩子都存在，选取左右孩子里面表小的，进行替换
                    if(leftChild<=maxSize && rightChild <= maxSize){
                        int choose = heap[leftChild]<heap[rightChild]? leftChild : rightChild;
                        if(heap[choose]<val){
                            swap(heap, cur, choose);
                            cur = choose;
                            leftChild = cur * 2;
                            rightChild = cur * 2 + 1;
                        }else {
                            break;
                        }
                        //仅左孩子存在，不存在右孩子
                    }else if(leftChild<=maxSize && heap[leftChild]<val){
                        swap(heap, cur, leftChild);
                        cur = leftChild;
                        leftChild = cur * 2;
                        rightChild = cur * 2 + 1;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void swap(int nums[], int i, int j){
        int tem = nums[j];
        nums[j] = nums[i];
        nums[i] = tem;
    }

    public int add(int val) {
        addItem(val);
        return heap[1];
    }


    /**
     * 引用比较多的是使用了优先级队列
     * ref:
     * https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/149050/Java-Priority-Queue
     * @param args

        final PriorityQueueDemo<Integer> q;
        final int k;

        public KthLargest(int k, int[] a) {
            this.k = k;
            q = new PriorityQueueDemo<>(k);
            for (int n : a)
                add(n);
        }

        public int add(int n) {
            if (q.size() < k)
                q.offer(n);
            else if (q.peek() < n) {
                q.poll();
                q.offer(n);
            }
            return q.peek();
        }

     */



    public static void main(String[] args) {
        int[] arr = new int[]{4,5,8,2};
        KthLargestElementInAStream kthLargest = new KthLargestElementInAStream(3, arr);
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));


    }
}
