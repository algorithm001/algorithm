class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        priority_queue<vector<int>, vector<vector<int>>, comp> p;
        for (int i=0; i < min((int)nums1.size(),k); i++) {
            for (int j=0; j < min((int)nums2.size(),k); j++) {
                vector<int> temp = {nums1[i], nums2[j]};
                if (p.size() < k) {
                    p.push(temp);
                } else {
                    if (nums1[i] + nums2[j] < p.top()[0] + p.top()[1]) {
                        p.push(temp);
                        p.pop();
                    }
                }
            }
        }
        
        vector<vector<int>> res;
        
        while (!p.empty()) {
            res.push_back(p.top());
            p.pop();
        }
        // reverse(res.begin(), res.end());
        
        return res;
        
    }
    
    struct comp {
        bool operator() (vector<int> &v1, vector<int> &v2) {
            return v1[0] + v1[1] < v2[0] + v2[1];
        }
    };
};
