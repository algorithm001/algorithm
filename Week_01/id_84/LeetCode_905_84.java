public class LeetCode_905_84 {
    public int[] sortArrayByParity(int[] A) {
        int length = A.length;
        if (length == 0) {
            return A;
        }
        int B[] = new int[length];
        int low = 0;
        int high = length - 1;
        for (int i = 0; i < length; i++) {
            if (A[i] % 2 == 0) {
                B[low++] = A[i];
            }
            else {
                B[high--] = A[i];
            }
        }
        return B;

    }
}
