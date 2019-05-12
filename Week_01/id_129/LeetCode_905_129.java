public class LeetCode_905_129 {
    public static int[] sortArrayByParity(int[] A) {
        int start = 0;
        int end = A.length - 1;
        while (start != end) {
            if (A[start] % 2 == 0) {
                start++;
                continue;
            }
            if (A[end] % 2 != 0) {
                end--;
                continue;
            }
            swap(A, start, end);
        }
        return A;
    }

    public static void swap(int[] src, int a, int b) {
        int temp = src[a];
        src[a] = src[b];
        src[b] = temp;
    }
}
