// Source : https://leetcode.com/problems/powx-n/
// Id     : 50
// Author : Fanlu Hai
// Date   : 2018-04-17
public class PowXN {

    //Time Limit Exceeded, this should be O(n) which means I need O(log(n)) or better.
    public double myPowVerySlow(double x, int n) {

        double result = x;
        if (n == 0) {
            return 1;
        }
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                result *= x;
            }
            return result;
        }
        n = -n;
        for (int i = 1; i < n; i++) {
            result *= x;
        }
        return 1 / result;
    }

    // x pow of n usually means you need to multiple x for n times, we can use dichotomy to reduce it.
    public double myPowWithOverflowProblem(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            //! here is the problem, -2147483648 will cause int overflow as it can't be bigger than 2147483647
            n = -n;
            x = 1 / x;
        }

        double result = 1;
        double tmp = x;

        while (true) {
            if (n == 1) {
                return result * tmp;
            }
            if (n % 2 == 1) {
                result *= tmp;

            }
            n /= 2;
            tmp *= tmp;
        }
    }


    // x pow of n usually means you need to multiple x for n times, we can use dichotomy to reduce it.
    // solved int overflow problem
    // did not use recursion
    // 82.1 100%
    public double myPow(double x, int n) {

        boolean minValue = false;
        if (n == 0 || x == 1) {
            return 1;
        }

        // handle -2147483648 in a not very clean way
        if (n == Integer.MIN_VALUE) {
            n++;
            minValue = true;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        double result = 1;
        double tmp = x;

        while (true) {
            if (n == 1) {
                if (minValue)
                    return result * tmp * x;
                return result * tmp;
            }
            if (n % 2 == 1) {
                result *= tmp;
            }
            n /= 2;
            tmp *= tmp;
        }
    }


    public static void main(String[] args) {
        PowXN powXN = new PowXN();
        System.out.println(powXN.myPow(2, 11));
        System.out.println(powXN.myPow(2, 12));
        System.out.println(powXN.myPow(5, -2));
        System.out.println(powXN.myPow(8, 4));
        System.out.println(powXN.myPow(0.9, 2147483647));
        System.out.println(powXN.myPow(1, -2147483647));
        System.out.println(powXN.myPow(0.3, -2147483648));
    }
}
