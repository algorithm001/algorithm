class KthLargest {
public:
    struct cmp{
        bool operator()(int &a, int &b){
            return a>b;
        }
    };
    priority_queue<int,vector<int>,cmp> numset;
    int cap;
    KthLargest(int k, vector<int>& nums) {
        cap = k;
        for(int i=0; i<nums.size(); i++)
            add(nums[i]);
    }
     
    int add(int val) {
        if(numset.size()<cap)
            numset.push(val);
        else if(numset.top() < val){
            numset.pop();
            numset.push(val);
        }
        return numset.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
