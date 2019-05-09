using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem210 : IProblem
    {
        public void RunProblem()
        {
            throw new NotImplementedException();
        }

        public int[] FindOrder(int numCourses, int[][] prerequisites)
        {
            /*
             * Topologcal Sort
             * 实现思路：借鉴广度优先搜索的思路来处理
             * 1.遍历一遍关系，得到一个“入度统计”；
             * 2.搜索输出入度为0的节点，并动态更新入度；
             * 3.如果入读为0的搜索完了，但是数组数量不足，那么就说明有环了！
             * 
             * 时间复杂度：O(n);
             * 空间复杂度：O(n);
             * Key Point，因为使用了“队列”以及借用了“BFS”的算法思想，所以复杂度才降低到O(n)；
             */

            int[] inCountArray = new int[numCourses];
            Dictionary<int, List<int>> fromToDic = new Dictionary<int, List<int>>();

            int w = prerequisites.GetLength(0);
            for(int i = 0; i < w; i++)
            {
                var toCourse = prerequisites[i][0];
                var fromCourse = prerequisites[i][1];

                if (!fromToDic.ContainsKey(fromCourse))
                    fromToDic[fromCourse] = new List<int>();
                fromToDic[fromCourse].Add(toCourse);

                inCountArray[toCourse] += 1;
            }

            Queue<int> inZeroNodes = new Queue<int>();
            for (int j = 0; j < numCourses; j++) if (inCountArray[j] == 0) inZeroNodes.Enqueue(j);

            List<int> forReturn = new List<int>();
            while(inZeroNodes.Count > 0)
            {
                int courseId = inZeroNodes.Dequeue();
                forReturn.Add(courseId);

                if (!fromToDic.ContainsKey(courseId)) continue;
                foreach(var toCourseItem in fromToDic[courseId])
                {
                    inCountArray[toCourseItem] -= 1;
                    if (inCountArray[toCourseItem] == 0) inZeroNodes.Enqueue(toCourseItem);
                }
            }

            return forReturn.Count == numCourses ? forReturn.ToArray() : new int[0];
        }
    }
}
