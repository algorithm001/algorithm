using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    /// <summary>
    /// 922. Sort Array By Parity II
    /// Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.You may return any answer array that satisfies this condition.
    /// </summary>
    public class LeetCode_922_086
    {
        /// <summary>
        /// 316ms 35.4MB
        /// </summary>
        /// <param name="A"></param>
        /// <returns></returns>
        public int[] MethodFor922_1(int[] A)
        {
            int n = A.Length;
            int[] B = new int[n];

            int e = 0;
            int o = 1;
            
            for (int i = 0; i < n; i++)
            {
                if (A[i] % 2 == 0)
                {
                    B[e] = A[i];
                    e = e + 2;
                }
                else
                {
                    B[o] = A[i];
                    o = o + 2;
                }
            }
            return B;
        }
    }
}
