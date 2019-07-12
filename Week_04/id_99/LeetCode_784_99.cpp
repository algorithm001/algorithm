class Solution {
public:
    void backTrace(vector<string>& res,string S,int i)
    {
        if(i > S.length()) {
            res.push_back(S);
            return;
        }
        
        string temp = S;
        if(S[i] >= 'a'&&S[i]<= 'z') {       
            temp[i] -= 32;
            backTrace(res,temp,i+1);
        } else if(S[i] >= 'A'&&S[i]<= 'Z') {       
            temp[i] += 32; 
            backTrace(res,temp,i+1);  
        }

        backTrace(res,S,i+1);
    }
    
    vector<string> letterCasePermutation(string S) {
        vector<string> res;
        backTrace(res,S,0);
        return res;
    }
};