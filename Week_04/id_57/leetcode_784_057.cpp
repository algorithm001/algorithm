class Solution {
public:
    void backtrade(string S, vector<string> &res,int i)
    {
        if (i > S.length())
        {
            res.push_back(S);
            return;
        }
        if ((S[i]  >= 'A') && (S[i] <= 'Z'))
        {            
            backtrade(S,res,i+1);
            S[i] += 32;    
            backtrade(S,res,i+1);
            
        }
        else if ((S[i] >='a') && (S[i] <= 'z'))
        {            
            backtrade(S,res,i+1);
            S[i] -= 32;    
            backtrade(S,res,i+1);
            
        }
        else
        {        
            backtrade(S,res,i+1);
        }
    }
    vector<string> letterCasePermutation(string S) {
        vector<string> res;
        backtrade(S,res,0);
        return res;
    }
};
