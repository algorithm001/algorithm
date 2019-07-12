#include <queue>
using namespace std;

class KthLargest {
public:
    int topK;
    priority_queue<int,vector<int>,greater<int>> bigHeapQ;
public:
    KthLargest(int k, vector<int>& nums) {
        topK = k;
        for(int i=0;i<nums.size();++i){
            add(nums[i]);
        }
    }
    
    int add(int val) {
        if(bigHeapQ.size() < topK) {
            bigHeapQ.push(val);
        } else if(bigHeapQ.top() < val) {
            bigHeapQ.pop();
            bigHeapQ.push(val);
        }
        return bigHeapQ.top();
    }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */