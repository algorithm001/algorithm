class Solution {

public:
    
struct cmpare {
    bool operator () (pair<int, int> a, pair<int, int> b) {
        return (a.first + a.second) > (b.first + b.second);
    }
};
    
vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
    
        priority_queue<pair<int, int>,vector<pair<int, int>>,cmpare> heap;
        int i,j;
        int len1 = nums1.size();
        int len2 = nums2.size();
    
        for (i = 0; i < len1; i++){
            for(j = 0; j < len2; j++) {
                heap.push(make_pair(nums1[i],nums2[j]));
            }
        }
        
        vector<vector<int> > res;
        while (k-- > 0 && heap.size() > 0) {
            vector<int> vec;
            pair<int,int> p1;
            p1 = heap.top();
            vec.push_back(p1.first);
            vec.push_back(p1.second);
            res.push_back(vec);
            heap.pop();
        }
    
        return res;
    }
};

