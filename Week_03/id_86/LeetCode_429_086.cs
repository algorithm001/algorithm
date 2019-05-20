using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    class LeetCode_429_086
    {
        public IList<IList<int>> LevelOrder(Node root)
        {
            IList<IList<int>> result = new List<IList<int>>();

            if (root != null)
            {
                var q = new Queue<Node>();
                q.Enqueue(root);

                while (q.Count != 0)
                {
                    int num = q.Count;
                    IList<int> r = new List<int>();

                    for (int i = 0; i < num; i++)
                    {
                        Node n = q.Dequeue();
                        r.Add(n.val);
                        foreach (Node c in n.children)
                        {
                            q.Enqueue(c);
                        }
                    }
                    result.Add(r);
                }
            }
            return result;
        }
    }
}


