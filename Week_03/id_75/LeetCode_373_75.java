//该题和合并k个排序列表相似
//nums1的一个数字和nums2的每个数字组合看成是一个列，有nums1.length个列表
//把所有列表的头放到小堆顶中,得到的堆顶就是最小的组合,取出堆顶后把对应列表里下一个节点放入小堆顶里重新堆化
class Solution {
    List<int[]> res = new ArrayList<>();
    private int[][] heap; //堆，从下表1开始存储数据
    private int max; //最大存储的数据个数
    private int count; //已经存储的数据个数
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        heap = new int[nums1.length + 1][3];
        max = nums1.length;
        count = 0;
        for(int i = 0; i < nums1.length && i < k; i++){
            insert(new int[]{nums1[i],nums2[0],0});
        }
        
        while(k-- > 0 && count > 0){
            int[] cur = getHeapTop();
            int[] result = new int[]{cur[0],cur[1]};
            res.add(result);
            if(cur[2] == nums2.length - 1) continue;
            insert(new int[]{cur[0],nums2[cur[2] + 1],cur[2] + 1});
        }
        return res;
    }
    
    //插入新元素到小堆顶
    private void insert(int[] data){
        if(count >= max) return;
        count++;
        heap[count] = data;
        int i = count;
        while(i / 2 > 0 && getSum(i/2) > getSum(i)){
            swap(heap,i,i/2);
            i = i/2;
        }
    }
    
    private int[] getHeapTop(){
        int[] tmp = heap[1];
        heap[1] = heap[count];
        --count;
        heapify(heap,count,1);
        return tmp;
    }
    
    private void heapify(int[][] a,int n,int i){
        while(true){
            int maxPos = i;
            if(i * 2 <= n && getSum(i) > getSum(i * 2)) maxPos = i * 2;
            if(i * 2 + 1 <= n && getSum(maxPos) > getSum(i  * 2 + 1)) maxPos = i * 2 + 1;
            if(maxPos == i) break;
            swap(heap, i, maxPos);
            i = maxPos;
        }
    }
    
    private void swap(int[][] heap,int i,int j){
        int[] tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }
              
    private int getSum(int s){
        return heap[s][0] + heap[s][1];
    }
}

//参考LeetCode如下解：
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }
}