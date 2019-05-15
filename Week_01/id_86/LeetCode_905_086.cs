using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    /// <summary>
    /// 905. Sort Array By Parity
    /// Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.You may return any answer array that satisfies this condition.
    /// </summary>
    public class LeetCode_905
    {
        /// <summary>
        /// 思路：第一个检查是否是奇数，如果是的话和最后一个交换，在进行检测是否是奇数，和倒数第二个交换，以此往后，到i=n-flag时截止
        /// </summary>
        /// 260 ms 31.9MB
        /// <param name="A"></param>
        /// <returns></returns>
        public int[] MethodFor905_1(int[] A)
        {
            int n = A.Length;
            int temp;
            int flag = 1;

            for (int i = 0; i < n ; i++)
            {
                if (A[i] % 2 == 1)
                {
                    temp = A[i];
                    A[i] = A[n - flag];
                    A[n - flag] = temp;

                    flag++;
                    i--;
                }
                if (i==n-flag) { break; }
            }
            return A;
        }

        /// <summary>
        /// 参考
        /// </summary>
        /// <param name="A"></param>
        /// <returns></returns>
        public int[] MethodFor905_2(int[] A)
        {
            int l = 0;
            int r = A.Length - 1;
            while (l < r)
            {
                while (l < r && A[l] % 2 == 0)
                {
                    l++;
                }
                while (l < r && A[r] % 2 == 1)
                {
                    r--;
                }
                if (l < r)
                {
                    int temp = A[l];
                    A[l] = A[r];
                    A[r] = temp;
                }
            }
            return A;
        }

        /// <summary>
        /// 参考
        /// </summary>
        /// <param name="A"></param>
        /// <returns></returns>
        public int[] MethodFor905_3(int[] A)
        {
            return A.Where(x => x % 2 == 0).Concat(A.Where(x => x % 2 != 0)).ToArray();
        }
    }
}
