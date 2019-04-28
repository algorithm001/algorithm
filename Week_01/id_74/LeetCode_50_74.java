class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return pow(1 / x, -n);
        }
        return pow(x, n);
    }
    
    public double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double result = pow(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
    }
}