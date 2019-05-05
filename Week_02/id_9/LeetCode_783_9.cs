using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem783 : IProblem
    {
        public class TreeNode
        {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        public void RunProblem()
        {
            throw new NotImplementedException();
        }

        public int MinDiffInBST(TreeNode root)
        {
            /*
             * 思路：遍历二叉搜索树，得到一个排序列表，依次比较列表两个相邻的数字，即可得到最小值
             * 
             * 时间复杂度：树遍历1次，数组遍历1次，O(n)；
             * 空间复杂度：额外存一个数组，所以是，O(n)；
             */

            RecursiveTree(root);
            return minValue;
        }

        private IList<int> arrayTemp = new List<int>();
        private int minValue = int.MaxValue;

        private void RecursiveTree(TreeNode tree)
        {
            if (tree == null) return;

            RecursiveTree(tree.left);

            arrayTemp.Add(tree.val);
            if (arrayTemp.Count > 1)
                minValue = Math.Min(arrayTemp[arrayTemp.Count - 1] - arrayTemp[arrayTemp.Count - 2], minValue);

            RecursiveTree(tree.right);
        }
    }
}
