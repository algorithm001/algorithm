/**
  * @author apple
  */ 
public class SortArrayByParityII {

    /**
     * 空间换时间； 时间复杂度 O(n), 空间复杂度 O(n)
     * 
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length <= 1)
            return A;
        int len = A.length;
        int[] arr = new int[len];

        int odd = 0;
        int even = 1;
        for (int i = 0; i < len; ++i) {
            // 奇数
            if (A[i] % 2 == 0) {
                arr[odd] = A[i];
                odd = odd + 2;
                // 偶数
            } else {
                arr[even] = A[i];
                even = even + 2;
            }
        }
        return arr;
    }
}
