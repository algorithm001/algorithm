using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode
{
    public class 按奇偶排序数组
    {
        public int[] SortArrayByParity(int[] A)
        {
            int[] o = new int[A.Count()];
            int[] e = new int[A.Count()];
            int p = 0;
            int q = 0;
            for (int i = 0; i < A.Count(); i++)
            {
                if (A[i] % 2 == 1)
                {
                    o[p] = A[i];
                    p++;
                }
                else
                {
                    e[q] = A[i];
                    q++;
                }
            }

            for (int i = 0; i < p; i++)
            {
                e[q] = o[i];
                q++;
            }

            return e;
        }
    }
}
