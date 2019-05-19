class Solution {
public:
    int minDistance(string word1, string word2) {
        int len1=word1.length(),len2=word2.length();
        //dp[index1][index2]:前index1个word1字符转换成前index2个word2字符需要的最少步数
        vector<vector<int>> dp(len1+1,vector<int>(len2+1));
        for(int index1=0;index1<=len1;index1++){
            for(int index2=0;index2<=len2;index2++){
                if(index1 == 0)
                    //从无到有显然要经历index2步插入操作
                    dp[index1][index2] = index2;
                else if(index2 == 0)
                    //从有到无显然要经历index1步删除操作
                    dp[index1][index2] = index1;
                //三种操作方式
                //1.word1删除末尾字符 dp[index1-1][index2]+1
                //2.word1在末尾插入字符 dp[index1][index2-1]+1
                //3.word1替换末尾字符(如果末尾字符本来就相等,就不用换了) dp[index1-1][index2-1]+(word1[index1-1]!=word2[index2-1]
                else dp[index1][index2] = min(min(dp[index1-1][index2]+1,dp[index1][index2-1]+1),dp[index1-1][index2-1]+(word1[index1-1]!=word2[index2-1]));
                //cout << dp[index1][index2] << " ";
            }
            //cout << endl;
        }
        return dp[len1][len2];
    }
};