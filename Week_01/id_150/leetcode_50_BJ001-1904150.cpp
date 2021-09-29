class Solution {
public:
    double myPow(double x, int n) {
        if(x == 0) return 0;
        if(n == 0) return 1;
        
        long long nn = n;
        double ans = res(x, nn < 0 ? -nn : nn);
        if(n < 0)
            return 1/ans;
        return ans;
    }
    double res(double x, long long n) {
        if(n == 1) return x;
        
        double once = res(x, n/2);
        if(n % 2) 
            return x * once * once;
        else
            return once * once;
    }
};