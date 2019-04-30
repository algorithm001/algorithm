using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem687 : IProblem
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

        public int LongestUnivaluePath(TreeNode root)
        {
            /*
             * 树的遍历，使用的是“根、左、右”的方式；
             * 遍历过程中，有两个职责：
             * 1.左右节点和自己同值，那么加起来和最大长度比较一下；
             * 2.若节点的值，与父节点的值相同，那么就把左右子树最大的值，再加上自己的值，返回给父节点；
             * 
             * 时间复杂度：就是把树遍历了一遍，顺便做了比较，所以是O(n)；
             * 空间复杂度：O(1)；
             */

            if (root == null) return 0;
            TreeSearch(root, root.val);
            return maxL;
        }

        private int maxL = int.MinValue;

        /// <summary>
        /// 二叉树遍历求值
        /// </summary>
        /// <param name="sonNode">子节点</param>
        /// <param name="val">父节点的值</param>
        /// <returns>与父节点值相同的节点个数</returns>
        private int TreeSearch(TreeNode sonNode, int val)
        {
            if (sonNode == null) return 0;

            //左右节点和自己同值，那么加起来和最大长度比较一下；
            var leftCount = TreeSearch(sonNode.left, sonNode.val);
            var rightCount = TreeSearch(sonNode.right, sonNode.val);
            maxL = Math.Max(leftCount + rightCount, maxL);

            //若节点的值，与父节点的值相同，那么就把左右子树最大的值，再加上自己的值，返回给父节点；
            if (sonNode.val == val) return Math.Max(leftCount, rightCount) + 1;

            return 0;
        }
    }
}
