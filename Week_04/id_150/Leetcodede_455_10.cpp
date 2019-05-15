class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        sort(g.begin(), g.end());
        sort(s.begin(), s.end());
        
        int gdx = 0, sdx = 0;
        
        int res = 0;
        while((gdx < g.size()) && (sdx < s.size())) {
            if(g[gdx] <= s[sdx]) {
                res++;
                gdx++;
                sdx++;
            } else {
                sdx++;
            }
        }
        
        return res;
    }
};

