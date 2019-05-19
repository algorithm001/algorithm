class Solution {
public:
    int i,j,m,n,index=2;//index用于标记不同岛序号
    const int left = 0;const int right = 1; //方向常量设置
    const int up = 2;const int down = 3;
    const int none = 4;
    vector<vector<int>> map;
    vector<int> tmp;
    int numIslands(vector<vector<char>>& grid) {
        if(!grid.size()) return 0;
        m = grid.size();n = grid[0].size();
        for(i=0;i<m;i++) {
            tmp.clear();
            for(j=0;j<n;j++) tmp.push_back(grid[i][j]-'0');
            map.push_back(tmp);
        }
        for(i=0;i<m;i++) 
           for(j=0;j<n;j++) 
                if(map[i][j]==1) dfs(i,j,none),index++;
        return index-2;
    }
    void dfs(int i,int j,int flag) { //flag判断来的方向，预防死环
        if(i<0||i>m-1||j<0||j>n-1) return;
        if(map[i][j]!=1) return;
        map[i][j] = index;
        if(flag!=right) dfs(i,j+1,left); 
        if(flag!=left) dfs(i,j-1,right);
        if(flag!=up) dfs(i+1,j,down);
        if(flag!=down) dfs(i-1,j,up);
    }
};