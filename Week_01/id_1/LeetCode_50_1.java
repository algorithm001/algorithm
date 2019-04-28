public class Solution {
    double myPow(double x, int n) {
        double result = this.pow(x, Math.abs(n));

        if (n < 0) {
            return 1/result;
        }
        return result;
    }

    private double pow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}

