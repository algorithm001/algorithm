using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace leetcode
{
    public class 最长同值路径
    {
        public class TreeNode
        {
            public int val;
            public TreeNode left;
            public TreeNode right;
            public TreeNode(int x) { val = x; }
        }

        int max = 0;

        public int LongestUnivaluePath(TreeNode root)
        {
            F(root);
            return max;
        }

        int F(TreeNode root)
        {
            if (root == null)
            {
                return 0;
            }

            int left = F(root.left);
            int right = F(root.right);
            if (root.val == root?.left?.val)
            {
                left++;
            }
            else
            {
                left = 0;
            }

            if (root.val == root?.right?.val)
            {
                right++;
            }
            else
            {
                right = 0;
            }

            max = Math.Max(left + right, max);
            return Math.Max(left, right);
        }
    }
}
