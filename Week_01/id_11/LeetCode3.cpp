class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
    string result;

    int max = 0;
    for(int i = 0; i < s.size(); ++i)
    {
        char str = s.at(i);
        int pos = result.find_first_of(str);
        if(pos != string::npos)
            result.erase(0,pos+1);
        result.push_back(str);
        if(result.size() > max)
        {
            max = result.size();
        }
      }

      return max; 
    }
};
