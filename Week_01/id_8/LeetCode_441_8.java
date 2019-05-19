class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2.0 * n + 0.25) - 0.5);
    }
}