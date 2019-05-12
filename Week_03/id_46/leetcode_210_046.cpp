class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> nodeLink(numCourses, vector<int>(0));
        vector<int> result,degree(numCourses,0);
        for(auto i:prerequisites){
            nodeLink[i[1]].push_back(i[0]);
            degree[i[0]]++;
        }
        queue<int> nodequeue;
        for(int i=0; i<degree.size(); i++){
            if(degree[i] ==0 ){
                nodequeue.push(i);
                result.push_back(i);       
            }
        }
        while(!nodequeue.empty()){
            int tmp = nodequeue.front();
            nodequeue.pop();
            for(auto i:nodeLink[tmp]){
                degree[i]--;
                if(degree[i]==0){
                    nodequeue.push(i);
                    result.push_back(i);  
                }
            }
        }
        for(int i=0; i<degree.size(); i++){
            if(degree[i] !=0 )
                result.clear();
        }
        return result;
    }
};
