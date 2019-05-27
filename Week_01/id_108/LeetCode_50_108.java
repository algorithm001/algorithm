import org.junit.Test;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/28
 */
public class LeetCode_50_108 {


    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }
        //对于myPow(2, -2147483648)，如果直接取绝对值就会溢出，导致Math.abs(n)还是负数,所以先除2再取绝对值
        double result = myPow(x, n == Integer.MIN_VALUE ? -(n/2) : Math.abs(n) / 2);

        if (n % 2 == 0) {
            result = result * result;
        } else {
            result = result * x * result;
        }

        if (n >= 0) {
            return result;
        } else {
            return 1.0 / result;
        }

    }
}
