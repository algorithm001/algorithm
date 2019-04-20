import java.util.Random;

public class LeetCode_905_85 {

}

/**
 * @Package:
 * @ClassName: LeetCode_905_85.ArraySortByParity
 * @Description: 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。 难度：简单
 * @leetcode url:https://leetcode.com/problems/sort-array-by-parity/
 * @Author: wangzhao
 * @Date: 2019-04-17 10:18:20
 * @Version: 1.0.0
 * @Since: 1.8
 **/
class ArraySortByParity {

    public int[] sortArrayByParity(int[] A) {

        if (A == null) return null;
        int prev = 0;
        int last = A.length - 1;

        for (int i = 0; i < A.length; i++) {

            if (prev >= last) {
                break;
            }
            if (A[prev] % 2 != 0 && A[last] % 2 == 0) {
                int temp = A[prev];
                A[prev] = A[last];
                A[last] = temp;
                prev++;
                last--;
                continue;
            }
            if (A[prev] % 2 == 0 && A[last] % 2 == 0) {
                prev++;
                continue;
            }
            if (A[prev] % 2 != 0 && A[last] % 2 != 0) {
                last--;
                continue;
            }
            if (A[prev] % 2 == 0 && A[last] % 2 != 0) {
                prev++;
                continue;
            }

        }
        return A;
    }


    public static void main(String[] args) {
        int[] arr = new int[10];

        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {

            int a = r.nextInt(100);
            System.out.print(a + ",");

            arr[i] = a;
        }
        System.out.println("");
        System.out.println("-----------我是分割线-------------");
        int[] arr2 = {0, 1, 2, 3};
        int[] result = new ArraySortByParity().sortArrayByParity(arr2);
        for (int i : result) {
            System.out.print(i + ",");
        }


    }
}