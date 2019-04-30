bool cmp_pair(pair<int,string> &x,pair<int,string> &y){
    return x.first>y.first || (x.first==y.first && x.second<y.second);
}

class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        vector<string> result;
        unordered_map<string,int> sfmap;
        for(int i=0; i<words.size(); i++)
                sfmap[words[i]]++;
        
        vector<pair<int,string>> fsmap;
        for(auto it = sfmap.begin(); it!=sfmap.end(); it++){
            fsmap.push_back(make_pair(it->second,it->first));
        }
        std::sort(fsmap.begin(),fsmap.end(),cmp_pair);
        
        for(int i=0; i<k; i++)
            result.push_back(fsmap[i].second);
        
        return result;
    }
};
