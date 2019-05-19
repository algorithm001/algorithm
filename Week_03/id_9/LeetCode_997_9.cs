using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem997 : IProblem
    {
        public void RunProblem()
        {
            throw new NotImplementedException();
        }

        public int FindJudge(int N, int[][] trust)
        {
            /*
             * 处理思路：
             * 1.遍历trust数组
             * 2.在自己的二维数组中，做统计
             * 3.在遍历完数组以后，在自己的二维数组中提取出目标值
             * 
             * 思考：
             * 1.因为 trust 的关系，这整个关系就是一个图；
             * 
             * 时间复杂度：O(n);
             * 空间复杂度：O(n);
             */

            //一维存储自己指向外界的个数，二维存储外界指向自己的个数，因为都是只统计个数，因为这个统计的数据结果并不复杂
            int[,] countArray = new int[N, 2];
            int w = trust.GetLength(0);

            for (int i = 0; i < w; i++)
            {
                int self = trust[i][0] - 1;
                int other = trust[i][1] - 1;

                countArray[self, 0] += 1;
                countArray[other, 1] += 1;
            }

            int forReturn = -1;
            for (int j = 0; j < N; j++)
            {
                if (countArray[j, 0] == 0 && countArray[j, 1] == N - 1)
                {
                    forReturn = j + 1;
                    break;
                }
            }

            return forReturn;
        }
    }
}
