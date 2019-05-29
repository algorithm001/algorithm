

    // LeetCode 703

    // [ 1. TopK 用小顶堆 ] 

    class KthLargest {

    private int[] heap;
    private int n;
    private int count;

    // 构造一个小顶堆
    public KthLargest(int k, int[] nums) {
        n = k;
        count = 0;
        // root放在数组的[1]
        heap = new int[k + 1];

        // 将nums中数据插入来构建大顶堆
        for (int i = 0; i < nums.length; i++) {
            insert(heap, nums[i]);
        }
    }

    // 在堆中查询，如果<=Top3(堆顶)，直接返回Top3
    // 如果>Top3，插入(替换堆顶)，重新堆化，然后返回堆顶
    public int add(int val) {

        insert(heap, val);
        int rst = heap[1];

        return rst;
    }

    // 边插入边堆化
    public void insert(int[] a, int m){
        // 堆满
        // 如果插入数 > Top3最小元素，即堆顶，替换
        // 否则，不插入
        int pos = 0;
        if (count >= n){
            if (m > a[1]){
                // 删除堆顶，最后一个元素替换，自上往下堆化
                a[1] = a[n];
                count --;
                heapifyFromPeak(a, n-1, 1);

            }else {
                return;
            }
        }
        // 插入元素到队尾，自下往上堆化
        count ++;
        a[count] = m;
        heapifyFromBottom(a, count);

    }

    /**
     *
     * @param n 堆当前元素个数
     */
    // 自下往上堆化
    public void heapifyFromBottom(int[] a, int n){
        int i = n;
        while (i/2 > 0 && a[i] < a[i/2]){
            swap(a, i, i/2);
            i = i/2;
        }
    }


    /**
     *
     * @param a 堆数组
     * @param n 元素个数
     * @param i 堆化的起始位置
     */
    // 自上往下堆化
    public void heapifyFromPeak(int[] a, int n, int i){
        //  找小的一边向下交换
        int minPos = i;
        if (i*2 <=n && i*2+1 <=n){
            if (a[i*2] < a[i*2+1]){
                if (i*2 <= n && a[i] > a[i*2]){
                    minPos = i*2;
                }else {
                    return;
                }
                swap(a, i, minPos);
                i = minPos;
            }else {
                if (i*2 <= n && a[i] > a[i*2]){
                    minPos = i*2+1;
                }
                else {
                    return;
                }
                swap(a, i, minPos);
                i = minPos;
            }
        }
        {
            while (true){
                minPos = i;
                if (i*2 <= n && a[i] > a[i*2]){
                    minPos = i*2;
                }
                else if (i*2+1 <= n && a[i] > a[i*2+1]){
                    minPos = i*2+1;
                }
                else if (minPos == i){
                    return;
                }
                swap(a, i, minPos);
                i = minPos;
            }
        }

    }

    public void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
    
    