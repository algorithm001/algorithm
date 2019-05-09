class KthLargest {
    private int count; //已经存储的数据个数
    private int max; //最大存储的数据个数
    private int[] heap; //用数组表示的堆，从下标1开始存储数据
    
    public KthLargest(int k, int[] nums) {
        heap = new int[k + 1];
        count = 0;
        max = k;
        for(int i = 0; i < nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        if(count < max){
            insert(val);
        }
        else if(heap[1] < val){
            removeMax();
            insert(val);
        }
        return heap[1];
    }
    
    //插入新元素到小堆顶
    public void insert(int data){
        count++;
        heap[count] = data;
        int i = count;
        while(i/2 > 0 && heap[i/2] > heap[i]){
            swap(heap,i,i/2);
            i = i/2;
        }
    }
    
    //删除小堆顶元素
    public void removeMax(){
        heap[1] = heap[count];
        --count;
        heapify(heap,count,1);
    }
    
    private void heapify(int[] a,int n,int i){//自上往下堆化
        while(true){
            int maxPos = i;
            if(i * 2 <= n && heap[i] > heap[i * 2]) maxPos = i * 2;
            if(i * 2 + 1 <= n && heap[maxPos] > heap[i * 2 + 1]) maxPos = i * 2 + 1;
            if(maxPos == i) break;
            swap(heap, i, maxPos);
            i = maxPos;
        }
    }
    
    private void swap(int[] a,int i,int j){
        int tmp = a[j];
        a[j] = a[i];
        a[i] = tmp;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */