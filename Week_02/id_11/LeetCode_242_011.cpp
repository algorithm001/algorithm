#include <string>
#include <unordered_map>
using namespace std;
class Solution {
public:
 bool isAnagram_1(string s, string t) {
        unordered_map<char,int> maps;
        for(int i = 0; i < s.size(); i++)
        {
            auto it =  maps.find (s[i]);
            if(it == maps.end())
            {
                maps[s[i]] = 0;
                continue;
            }
            maps[s[i]]++;
        }


        unordered_map<char,int> mapt;
        for(int i = 0; i < t.size(); i++)
        {
            auto  it = mapt.find (t[i]);
            if(it == mapt.end())
            {
                mapt[t[i]] = 0;
                continue;
            }
            mapt[t[i]]++;
        }


        for(auto it =maps.begin(); it != maps.end();++it)
        {
            auto f = mapt.find(it->first);
            if(f == mapt.end() || f->second != it->second)
            {
                return false;
            }
        }

        return true;

    }
    bool isAnagram_2(string s, string t) {

        int i, x[26] = {0},y[26] = {0};
        for(i = 0; s[i]!='\0';i++) x[s[i] - 'a']++;
        for(i = 0; t[i]!='\0';i++) y[t[i] - 'a']++;
        for(i = 0; i < 26; i++)
        {
            if(x[i] != y[i])
            {
                return false;
            }
        }
        
        return true;
        
    }
};
