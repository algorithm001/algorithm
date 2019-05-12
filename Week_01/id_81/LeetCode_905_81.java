/*
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
你可以返回满足此条件的任何数组作为答案。
示例：
    输入：[3,1,2,4]
    输出：[2,4,3,1]
    输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
提示：
    1 <= A.length <= 5000
    0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    /*
     * @desc 使用两个指针分别指向数组的首尾
     */
    public static int[] sortArrayByParity(int[] A) {
        if (A == null || A.length <= 1)
            return A;
        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            if (A[start] % 2 == 1 && A[end] % 2 == 0) {
                int temp = A[start];
                A[start] = A[end];
                A[end] = temp;
                start++;
                end--;
            } else if (A[start] % 2 == 0 && A[end] % 2 == 1) {
                start++;
                end--;
            } else if (A[start] % 2 == 1 && A[end] % 2 == 1) {
                end--;
            } else if (A[start] % 2 == 0 && A[end] % 2 == 0) {
                start++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
        sortArrayByParity(array);
        for (int item : array) {
            System.out.print(item + " ");
        }

    }
}
