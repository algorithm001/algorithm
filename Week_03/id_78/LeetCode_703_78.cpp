class KthLargest {
public:
    
    KthLargest(int k, vector<int>& nums) {
        m_size = k;
        int len = nums.size();
        int i = 0;
        for (i = 0; i < len; i++) {
            heap.push(nums[i]);
            if (heap.size() > m_size) {
                heap.pop();
            }
        } 
    }
    
    int add(int val) {
        heap.push(val);
        if (heap.size() > m_size) {
            heap.pop();
        }
        
        return heap.top();
    }
    
private:
    priority_queue<int, vector<int>, greater<int> > heap;
    int m_size;

};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */

