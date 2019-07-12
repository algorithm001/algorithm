class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        
        vector<int> record( N + 1, 0);
        
        for( int i = 0; i < trust.size(); i++){
            record[ trust[i][0]] = -1;
            if( record[trust[i][1]] != -1)
                record[trust[i][1]]++;
        }
        
        int max_pos = -1, max_num = -1;
        for( int i = 1; i < record.size(); i++){
          //  cout<<record[i]<<' ';
            if( record[i] != -1 && record[i] > max_num)
                max_pos = i, max_num = record[i];
        }
            
        if( max_num == N - 1)
            return max_pos;
        return -1;
        
    }
};
