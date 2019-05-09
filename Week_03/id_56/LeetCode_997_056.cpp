class Solution {
public:
    int findJudge(int N, vector<vector<int>>& trust) {
        int record[1001]={0};
        for(auto item:trust){
            record[item[1]]++;
            record[item[0]]--;
        }
        for(int i=1;i<=N;i++){
            if(record[i]==N-1){
                return i;
            }
        }
        return -1;
    }
};
