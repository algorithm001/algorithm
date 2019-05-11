public class LeetCode_50_85 {
}

/**
 * @Package:
 * @ClassName: PowXN
 * @Description: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。 难度：中
 * @leetCode url:https://leetcode.com/problems/powx-n/
 * @Author: wangzhao
 * @Date: 2019-04-20 11:56:45
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class PowXN {

    /**
     * leetcode结果超时
     */
    public double myPow2(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        double r = 1;

        for (int i = 0; i < (n < 0 ? -n : n); i++) {
            r = r * x;
        }
        if (n < 0) {
            return 1 / r;
        } else {
            return r;
        }
    }

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }

        if (n < 0) {
            return 1 / power(x, n);
        } else {
            return power(x, n);
        }

    }

    public double power(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double result = power(x, n / 2);
        if (n % 2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }

    }

    public static void main(String[] args) {
        double res = new PowXN().myPow(2.00, 10);
        System.out.println(res);
    }
}
