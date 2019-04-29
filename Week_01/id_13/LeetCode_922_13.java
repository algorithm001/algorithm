package leetCode;

public class LeetCode_922_13 {
    public int[] sortArrayByParityII(int[] A) {
        int[] N = new int[A.length];
        int m = 0;
        int k = 1;

        for (int a : A) {
            if (a % 2 == 0) {
                N[m] = a;
                m += 2;
            } else {
                N[k] = a;
                k += 2;
            }
        }

        return N;
    }
}
