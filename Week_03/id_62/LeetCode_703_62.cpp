class KthLargest {
public:
    KthLargest(int k, vector<int>& nums) {
        size = k;
        for (int i = 0; i < nums.size(); i++){
            heap.push(nums[i]);
        }
        if (heap.size() > k)
        {
            heap.pop();
        }
    }
    
    int add(int val) {
        heap.push(val);
        if (heap.size() > size)
        {
            heap.pop();
        }
        return heap.top();
    }
     private:
    priority_queue<int, vector<int>, greater<int>>heap;
    int size;
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 
 /**
* Your KthLargest object will be instantiated and called as such:
* KthLargest obj = new KthLargest(k, nums);
* int param_1 = obj.add(val);
*/
