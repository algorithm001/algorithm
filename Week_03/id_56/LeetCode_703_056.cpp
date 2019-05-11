class KthLargest {
public:
    int n;
    priority_queue<int,vector<int>,greater<int>> q; //建立最小堆
    //priority_queue<int> 默认大顶堆
    KthLargest(int k, vector<int>& nums) {
        n=k;     
        for(int i=0;i<nums.size();++i)
            add(nums[i]);
    }
    int add(int val) {
        if(q.size()<n) q.push(val);   
        else if(q.top()<val) { //只需维护最大的k个数 
            q.pop();
            q.push(val);
        }
        return q.top(); 
    }
};
