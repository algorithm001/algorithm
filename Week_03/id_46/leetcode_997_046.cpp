class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        unordered_map<int,set<int>> trustGraph;
        for(int i=1; i<=N; i++){
            set<int> tmp;
            trustGraph[i] = tmp;
        }
        
        for(int i=0; i<trust.size(); i++)
            trustGraph[trust[i][0]].insert(trust[i][1]);
        
        int res = 0, num = 0;
        for(auto it=trustGraph.begin(); it!=trustGraph.end(); it++){
            if(it->second.size()==0){
                num ++;
                if(num > 1) return -1;
                res = it->first;
            }
        }
        
        for(auto it=trustGraph.begin(); it!=trustGraph.end(); it++){
            if(it->first != res){
                auto iter = it->second.find(res);
                if(iter == it->second.end())
                    return -1;
            }
        }
        
        return res;
    }
};
