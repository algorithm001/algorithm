class KthLargest {
public:
    KthLargest(int k, vector<int>& nums) {
        for (auto num:nums) {
            q.push(num);
            if(q.size() > k) q.pop();
        }
        K = k;
    }
    
    int add(int val) {
        q.push(val);
        if (q.size() > K) q.pop();
        
        return q.top();
    }
private:
    int K;
    priority_queue<int, vector<int>, greater<int>> q; 
};
