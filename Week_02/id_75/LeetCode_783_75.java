/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//minimum-distance-between-bst-nodes(二叉搜索树-简单)
//中序遍历二叉树，获取所有节点的值是从小到大排好序的，然后依次对比相邻值之间的差值，取最小值
class Solution {
    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        LDR(root,list);
        int min = Integer.MAX_VALUE; 
        for(int i = 1; i < list.size(); i++){
            min = Math.min((list.get(i) - list.get(i - 1)),min);
        }
        return min;
    }
    private void LDR(TreeNode root,ArrayList<Integer> list){
        if(root == null) return;
        LDR(root.left,list);
        list.add(root.val);
        LDR(root.right,list);
    }
}