class Solution {
public:
    vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> res;
        vector<vector<int>> mark;
        vector<string> item;
        for(int i = 0; i < n; i ++)
        {
            mark.push_back(vector<int>());
            for(int j = 0; j < n; j ++)
            {
                mark[i].push_back(0);
            }
            item.push_back("");
            item[i].append(n,'.');//添加n个'.'
        }
        generate(0, n, item, res, mark);
        return res;
    }
    //回溯法
    void generate(int k, int n, vector<string> &item, vector<vector<string>> &res, vector<vector<int>> &mark)
    {
        if(k == n)
        {
            res.push_back(item);
            return;
        }
        for(int i = 0; i < n; i ++)
        {
            if(mark[k][i] == 0)
            {
                vector<vector<int>>  tmp_mark = mark;
                item[k][i] = 'Q';
                put_down_the_queen(k, i, mark);//更新mark矩阵
                generate(k + 1, n, item, res, mark);
                mark = tmp_mark;
                item[k][i] = '.';
            }
        }
    }
    //放下queen后更新mark矩阵
    void put_down_the_queen(int x, int y, vector<vector<int>> &mark)
    {
        static const int dx[] = {-1, 0, 1, -1, 1, -1, 0, 1};
        static const int dy[] = {1, 1, 1, 0, 0, -1, -1, -1};
        mark[x][y] = 1;
        for(int i = 1; i < mark.size(); i ++)
        {
            for(int j = 0; j < 8; j ++)
            {
                int new_x = x + i * dx[j];
                int new_y = y + i * dy[j];
                if(new_x >= 0 && new_x < mark.size() && new_y >= 0 && new_y < mark.size()) 
                    mark[new_x][new_y] = 1;
            }
        }
    }
};