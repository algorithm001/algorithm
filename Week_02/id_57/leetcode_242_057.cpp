class Solution {
public:
    bool isAnagram(string s, string t) {
        int A[26] = {0};
        int B[26] = {0};
        int i = 0;
        int j = 0;
        
        while(s[i] != '\0')
        {
            j = s[i] - 'a';
            A[j]++;
            i++;
        }
        
        i = 0;
        while(t[i] != '\0')
        {
            j = t[i] - 'a';
            B[j]++;
            i++;
        }
        
        for(i = 0; i < 26; i++)
        {
            if(A[i]!=B[i])
                return false;
        }
        return true;
        
    }
};