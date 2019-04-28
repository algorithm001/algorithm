/**
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class Leetcode_905_140 {

    /**
     * 程序入口
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 0) {
            return new int[0];
        }

        int even = 0;
        int odd = A.length - 1;
        int[] ret = new int[A.length];
        int i = 0;
        while (even <= odd) {
            if (A[i] % 2 == 1) {
                ret[odd--] = A[i];
            } else {
                ret[even++] = A[i];
            }
            i++;
        }
        return ret;
    }

}
