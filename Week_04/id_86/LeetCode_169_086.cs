using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    class LeetCode_169_086
    {
        public int MethodFor169_1(int[] num)
        {
            int n = num[0];
            int count = 1;

            for (int i = 1; i < num.Length; i++)
            {
                if (count == 0)
                {
                    count++;
                    n = num[i];
                }
                else if (n == num[i])
                {
                    count++;
                }
                else count--;

            }
            return n;
        }

        //直接调用 Array.Sort
        public int MethodFor169_2(int[] num)
        {
            Array.Sort(num);
            return num[num.Length / 2];
        }
    }
}
