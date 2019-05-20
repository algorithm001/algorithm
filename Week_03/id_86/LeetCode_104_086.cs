using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AlgorithmTest
{
    class LeetCode_104_086
    {
        public int MaxDepth(TreeNode root)
        {
            if (root == null) return 0;
            return Math.Max(MaxDepth(root.left), MaxDepth(root.right)) + 1;
        }
    }
}
