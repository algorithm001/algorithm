import org.junit.Test;

/**
 * @author zhangruihao.zhang
 * @version v1.0.0
 * @since 2019/05/26
 */
public class LeetCode_441_108 {


    public int arrangeCoins1(int n) {
        if (n == 0) {
            return 0;
        }
        int m = n;
        int k = 0;
        for (; m > 0; ) {
            if (m >= k + 1) {
                k++;
                m = m - k;
            } else {
                return k;
            }
        }
        return k;
    }

    public int arrangeCoins2(int n) {
        if (n == 0) {
            return 0;
        }
        return (int)(Math.sqrt(2.0*n+0.25)-0.5);
    }

    public int arrangeCoins3(int n) {
        if (n == 0) {
            return 0;
        }

        int low = 1;
        int high = n;
        int mid;
        double tmp;
        while (low <= high){
            mid = (high + low)/2;
            tmp = (mid * mid + mid) / 2.0;
            if(tmp == n){
                return mid;
            }else if (tmp < (double) n){
                low = mid + 1 ;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }
}
