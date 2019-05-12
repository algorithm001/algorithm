class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(),g.begin()+g.size());
        sort(s.begin(),s.begin()+s.size());
        int i=0,j=0;
        while(i<g.size()&&j<s.size()){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }
};
