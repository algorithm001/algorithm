class Solution {

    public int[] sortArrayByParity(int[] A) {
        int p = 0;
        int q = A.length - 1;
        while (p < q) {
            if (A[p] % 2 == 0) {
                p++;
            } else if (A[q] % 2 == 0) {
                int temp = A[q];
                A[q] = A[p];
                A[p] = temp;
                p++;
                q--;
            } else {
                q--;
            }
        }
        return A;
    }
}
