class KthLargest {
    //通过小顶堆来完成排序
    private Heap heap;

    public KthLargest(int k, int[] nums) {
        heap = new Heap(k);
        for(Integer value:nums){
            heap.insert(value);
        }       
    }
    
    public int add(int val) { 
        return heap.insert(val);
    }
    
    class Heap{
        //数组 从下标为1开始存储数据
        private int[] data;
        //堆可以存储的最大数据个数
        private int capacity;
        //堆已经存储的数据个数
        private int count;
        
        public Heap(int capacity){
            this.data = new int[capacity+1];
            this.capacity = capacity; 
            this.count = 0;
        }
        
        // 堆中添加元素
        public int insert(int value){
            if(count >=capacity){
                if(value>data[1]){
                    // 堆已满 且添加元素大于堆顶元素时将元素添加到堆顶
                    data[1] = value;
                    //自上而下堆化
                    heapify(1);
                }    
            }else{
                //堆未满 自下而上堆化
                data[++count] = value;
                int pointer = count;
                while(pointer >> 1>0 && data[pointer] < data[pointer >> 1]){
                    swap(pointer,pointer >> 1);
                    pointer = pointer >> 1;
                } 
            }

            return data[1];
        }
        
        public void swap(int i,int j){
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
        }
        
        public int removeMin(int value){
                if(count==0){
                    return -1;
                }
                int top = data[1];
                data[1] = data[count];
                count--;
                //堆化
                heapify(1); 
            return top;
        }
        
        public void heapify(int n){
            int minIndex;
            int left = n << 1;
            int right = left +1;
            if(left <= capacity && right<= capacity){
               minIndex = data[left] < data[right] ? left : right; 
            }else if(left <= capacity){
              minIndex = left;  
            }else{
                return;
            }

            if(data[n] > data[minIndex]){
                swap(n,minIndex);
                heapify(minIndex);
            }
        }
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */