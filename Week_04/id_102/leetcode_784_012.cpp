/*
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

示例:
输入: S = "a1b2"
输出: ["a1b2", "a1B2", "A1b2", "A1B2"]

输入: S = "3z4"
输出: ["3z4", "3Z4"]

输入: S = "12345"
输出: ["12345"]
*/

class Solution {
public:
    vector<string> letterCasePermutation(string S) {
        if(S.empty()) {
            return {}; 
        }
            
        vector<string> vec;
        Permutation(0, vec, S);
        return vec;
    }

private:
    void Permutation(int idx, vector<string>& ans, string S) {
        if (idx == S.size()) {
            ans.push_back(S);
            return;
        }
        
        if (S[idx] >= '0' && S[idx] <= '9') {
            Permutation(idx + 1, ans, S);
            return;
        } 
        
        if (S[idx] >= 'A' && S[idx] <= 'Z') {
            S[idx] = tolower(S[idx]);
        } 
        Permutation(idx + 1, ans, S);
        
        if (S[idx] >= 'a' && S[idx] <= 'z') {
            S[idx] = toupper(S[idx]);
        }
        Permutation(idx + 1, ans, S);
         
        return;
    }
};


