
class Solution {
    /**
     * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
     * Medium
     * 863. All Nodes Distance K in Binary Tree
     *
     * We are given a binary tree (with root node root), a target node, and an integer value K.
     *
     * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
     *
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
     *
     *
     *           （3）
     *           /   \
     *          /     \
     *       （5）    (1)
     *       / \     /  \
     *      /   \   (0) (8)
     *     /     \
     *    (6)   (2)
     *         /   \
     *       (7)   (4)
     *
     *
     * Output: [7,4,1]
     *
     * Explanation:
     * The nodes that are a distance 2 from the target node (with value 5)
     * have values 7, 4, and 1.
     *
     * Note that the inputs "root" and "target" are actually TreeNodes.
     * The descriptions of the inputs above are just serializations of these objects.
     *
     * Note:
     *
     * The given tree is non-empty.
     * Each node in the tree has unique values 0 <= node.val <= 500.
     * The target node is a node in the tree.
     * 0 <= K <= 1000.
     *
     * thanks to https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143798/1ms-beat-100-simple-Java-dfs-using-hashmap-with-explanation
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> ans = new ArrayList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        find(root, target, map);
        dfs(root, K, map.get(root), map, ans);
        return ans;

    }

    /**
     *
     * 找出从根节点到目标节点的路径；存储这条路径上每个节点到目标节点的距离的址
     * find all the path to target, and store each distance to the target for node.
     *
     */
    private int find(TreeNode root, TreeNode target, Map<TreeNode, Integer> map) {
        if(root == null)return -1;
        if(root == target)
        {
            map.put(root, 0);
            return 0;
        }
        int leftDistance = find(root.left, target, map);
        if(leftDistance >= 0)
        {
            map.put(root, leftDistance +1);
            return leftDistance +1;
        }

        int rightDistance = find(root.right, target, map);
        if(rightDistance >= 0)
        {
            map.put(root, rightDistance +1);
            return rightDistance +1;
        }

        return -1;
    }

    /**
     *
     * 基本思路为：对于任意一个节点，假设该节点到目标节点的距离为K，那么这个节点的子节点到目标节点的距离为 K + 1
     *
     * 如果该结点的子节点到目标节点的距离更进，说明目标节点为该节点的子节点——这种场景单独记录
     *
     */
    private void dfs(TreeNode root, int K,int distance, Map<TreeNode,Integer> map, List<Integer> ans) {
        if(root == null) {
            return;
        }
        //特殊节点的距离存储起来
        if(map.containsKey(root)) {
            distance = map.get(root);
        }
        if(distance == K) {
            ans.add(root.val);
        }

        //剪肢：更远的距离节点不再搜索
        if(!map.containsKey(root) && distance > K){
            return;
        }


        dfs(root.left, K, distance +1, map, ans);

        //System.out.println(distance + " -------now");

        dfs(root.right, K, distance +1, map, ans);

    }
}