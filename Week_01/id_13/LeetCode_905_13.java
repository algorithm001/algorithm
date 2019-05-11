package leetCode;

public class LeetCode_905_13 {
    public int[] sortArrayByParity(int[] A) {

        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            if (A[i] % 2 == 0) {
                i++;
            } else if (A[j] % 2 == 0) {
                // swap(A[i],A[j])
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            } else if (A[j] % 2 != 0) {
                j--;
            }
        }

        return A;
    }
}
