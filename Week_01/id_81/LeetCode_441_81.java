class Solution {
    public int arrangeCoins(int n) {
        if(n==1)
            return 1;
        int index = 1;
        while(index<=n){
            n = n-index;
            index = index+1;
            if(n<index){
                break;
            }
        }
        return index-1;
    }
}
