using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProblemSolutions
{
    public class Problem863 : IProblem
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

        public IList<int> DistanceK(TreeNode root, TreeNode target, int K)
        {
            /*
             * 思路：记录所有节点的路径，把目标的路径单据拎出来，通过比较“路径字符串”就能知道距离了
             * 
             * 时间复杂度：对树做了两次遍历，每个节点是对路径做了简单遍历，所以是 O(n*Deep)
             * 空间复杂度：存储了一个HashTable，所以是 O(n)
             */

            IList<int> forReturn = new List<int>();

            RecursiveTree(root, target, "");

            foreach(var dicItem in nodePath)
            {
                //去掉两个字符串中相同的部分
                int i = 0;
                for (i = 0; i < targetPath.Length && i < dicItem.Value.Length && dicItem.Value[i] == targetPath[i]; i++) ;

                //查看不同部分的长度，即可知道距离了
                if (targetPath.Length - i + dicItem.Value.Length - i == K)
                    forReturn.Add(dicItem.Key.val);
            }

            return forReturn;
        }

        private string targetPath = "";
        private Dictionary<TreeNode, string> nodePath = new Dictionary<TreeNode, string>();

        private void RecursiveTree(TreeNode root,TreeNode target,string path)
        {
            if (root == null) return;

            if (root == target) targetPath = path;

            nodePath[root] = path;

            RecursiveTree(root.left, target, path + "0");
            RecursiveTree(root.right, target, path + "1");
        }
    }
}
