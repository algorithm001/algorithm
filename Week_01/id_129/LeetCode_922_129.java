public class LeetCode_922_129 {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int limit = A.length - 1;
        while (i <= limit && j <= limit) {
            if (A[i] % 2 == 0) {
                i += 2;
                continue;
            }
            if (A[j] % 2 != 0) {
                j += 2;
                continue;
            }
            swap(A, i, j);
        }
        return A;
    }

    public void swap(int[] src, int a, int b) {
        int temp = src[a];
        src[a] = src[b];
        src[b] = temp;
    }
}
