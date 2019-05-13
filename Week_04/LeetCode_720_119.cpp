class Solution {
public:
    string longestWord(vector<string>& words) {
        string res = "";
        unordered_set<string> s;
        sort(words.begin(), words.end());
        for (string word:words) {
            if (word.size() == 1 || s.count(word.substr(0, word.size() - 1))) {
                res = word.size() > res.size() ? word : res;
                s.insert(word);
            }
        }
        return res;
    }
};
