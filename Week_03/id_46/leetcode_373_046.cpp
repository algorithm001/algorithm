class Solution {
public:
struct cmp{
    bool operator() ( pair<int,int> &a, pair<int,int> &b ){  
        return a.first + a.second <= b.first + b.second; }
};
vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
    priority_queue<pair<int,int>,vector<pair<int,int>>,cmp> q;
    for(int i=0; i<min((int)nums1.size(), k); i++){
        for(int j=0; j<min((int)nums2.size(), k); j++){
            q.push(make_pair(nums1[i],nums2[j]));
            if(q.size()>k)
                q.pop();
        }
    }
    vector<vector<int>> result;
    while(q.size()>0){
        vector<int> tmp;
        tmp.push_back(q.top().first);
        tmp.push_back(q.top().second);
        result.push_back(tmp);
        q.pop();
    }
    return result;
}
};
