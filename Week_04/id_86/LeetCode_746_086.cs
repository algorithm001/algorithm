using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    class LeetCode_746_086
    {
        public int MethodFor746_1(int[] cost)
        {
            for (int i = 2; i < cost.Length; i++)
            {
                cost[i] += Math.Min(cost[i - 2], cost[i - 1]);
            }

            return Math.Min(cost[cost.Length - 1], cost[cost.Length - 2]);
        }
    }
}
