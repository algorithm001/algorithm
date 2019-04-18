using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode
{
    public class 按奇偶排序数组_II
    {
        public int[] SortArrayByParityII(int[] A)
        {
            int[] o = new int[A.Length];
            int p = 0;
            int q = 1;
            for (int i = 0; i < A.Length; i++)
            {
                if (A[i] % 2 == 0)
                {
                    o[p] = A[i];
                    p += 2;
                }
                else
                {
                    o[q] = A[i];
                    q += 2;
                }
            }
            return o;
        }
    }
}
