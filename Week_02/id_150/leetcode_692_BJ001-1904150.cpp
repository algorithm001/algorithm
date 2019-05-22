typedef pair<string, int> P;
struct cmp
{
    bool operator()(const P p1, const P p2)
    {
        if(p1.second != p2.second)
            return p1.second < p2.second;
        return p1.first > p2.first;
    }

};

class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        vector<string> ans;
        
        map<string, int> mp;
        map<string, int> :: iterator iter;
        for(int i = 0; i < words.size(); i++) {
            string tmp = words[i];
            if(mp.find(tmp) != mp.end()) {
                mp[tmp]++;
            } else {
                mp[tmp] = 1;
            }
        }
        
        priority_queue<P, vector<P>, cmp> que;
        for(iter = mp.begin(); iter != mp.end(); iter++) {
            que.push(P(iter->first, iter->second));
        }
        
        while(ans.size() != k) {
            P tmp = que.top();
            ans.push_back(tmp.first);
            que.pop();
        }
    
        return ans;
    }
};

