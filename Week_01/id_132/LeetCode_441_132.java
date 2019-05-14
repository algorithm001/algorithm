class Solution {
    public int arrangeCoins(int n) {
        int curCoins = 1, residual = n - 1;
        while (residual >= curCoins + 1) {
            ++curCoins;
            residual -= curCoins;
        }
        return n == 0 ? 0 : curCoins;
    }
}
