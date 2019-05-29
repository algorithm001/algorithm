using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    public class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public class LeetCode_671_086
    {
        /// <summary>
        /// return 太多，感觉不是很好
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public int MethodFor671_1(TreeNode root)
        {
            if (root == null) return -1;
            var result = DFS(root);
            if (result == int.MaxValue) return -1;
            return result;
        }

        public int DFS(TreeNode root)
        {
            if (root == null) return int.MaxValue;

            if (root.left != null)
            {
                if (root.left.val == root.right.val)
                {
                    return Math.Min(DFS(root.left), DFS(root.right));
                }
                else
                {
                    if (root.left.val == root.val)
                    {
                        return Math.Min(root.right.val, DFS(root.left));
                    }
                    else
                    {
                        return Math.Min(root.left.val, DFS(root.right));
                    }
                }
            }

            return int.MaxValue;
        }


        public int MethodFor671_2(TreeNode root)
        {
            int min = root.val;
            int smin = root.val;
            return FindSMinValue(min, smin, root);
        }
        public int FindSMinValue(int min, int smin, TreeNode root)
        {

            if (root.left != null)
                smin = FindSMinValue(min, smin, root.left);

            if (root.val < min)
                min = root.val;

            if (smin == min && root.val > smin)
                smin = root.val;

            if (root.val > min && smin == -1)
            {
                smin = root.val;
            }
            else if (root.val > min && root.val < smin)
            {
                smin = root.val;
            }

            if (root.right != null)
                smin = FindSMinValue(min, smin, root.right);

            if (min < smin)
                return smin;
            else
                return -1;
        }

             
        public int[] second = new int[] { int.MaxValue, int.MaxValue };
        public int updatetime = 0;
        /// <summary>
        /// 通俗易懂
        /// </summary>
        /// <param name="root"></param>
        /// <returns></returns>
        public int MethodFor671_3(TreeNode root)
        {
            PDFS(root);
            if (updatetime < 2) return -1;
            return second[1];
        }
        public void PDFS(TreeNode root)
        {
            if (root == null) return;

            if (root.val < second[0])
            {
                second[1] = second[0];
                second[0] = root.val;
                updatetime++;
            }

            if (root.val < second[1] && root.val > second[0])
            {
                second[1] = root.val;
                updatetime++;
            }

            if (root.left != null) PDFS(root.left);
            if (root.right != null) PDFS(root.right);
        }
    }
}
