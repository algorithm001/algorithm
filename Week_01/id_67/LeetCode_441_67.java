class Solution {
    public int arrangeCoins(int n) {
        long start = 0, end = (long) n / 2 + 1, mid;
        while (end - start > 1) {
            mid = (start + end) >>> 1;
            if (mid * (mid + 1) == (long) 2 * n) {
                return (int) mid;
            } else if (mid * (mid + 1) <= (long) 2 * n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return (end * (end + 1) == (long) 2 * n) ? (int) end : (int) start;
    }


    public int arrangeCoins2(int n) {
        if(n == 0) return 0;
        int i=0;
        while(n>i){

            ++i;
            n-=i;
        }
        return i;
    }

    public int arrangeCoins3(int n) {
        return (int) (Math.sqrt((double) 2*n+0.5)-0.5);
    }

}