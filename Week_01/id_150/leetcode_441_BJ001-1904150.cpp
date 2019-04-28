class Solution {
public:
    int arrangeCoins(int n) {
        int res = int (sqrt((2 * (n + 0.0)) + 0.25) - 0.5);
        int tmp =  res%2 == 0 ? (res/2*res) : (res+1)/2*res; 
        if(tmp <= n) return res;
        return res - 1;
    }
};
