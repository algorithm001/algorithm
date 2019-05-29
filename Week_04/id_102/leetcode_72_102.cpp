class Solution {
public:
    int minDistance(string word1, string word2) {
        int row = word1.size();
        int column = word2.size();
        
        int f[row+1][column+1];
        for (int i = 0; i <= row; i++) {
            f[i][0] = i;
        }
        
        for (int j = 0; j <=column; j++) {
            f[0][j] = j;
        }
        
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (word1[i-1] == word2[j-1]) {
                    f[i][j] = f[i-1][j-1];
                } else {
                    f[i][j] = 1 + min(f[i-1][j-1], min(f[i][j-1], f[i-1][j]));
                }
            }
        }
        return f[row][column];
    }
};
