class KthLargest {
public:
    int n;
    priority_queue<int, vector<int>, greater<int>> q; /* 建立最小堆*/ 
    
    KthLargest(int k, vector<int>& nums) {
        n = k;
        for (auto i:nums){
            add(i);
        }    
    }
    
    int add(int val) {
        /* 存放最大的K个数 */
        if (q.size() < n) {
            q.push(val);
        } else {
            if (q.top() < val) {
                q.push(val);
                q.pop();               
            }
        }
        
        return q.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
