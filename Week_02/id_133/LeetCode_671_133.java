/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        //创建一个treeSet 
        //通过treeSet的方法higher：返回此set中严格大于给定元素的最小元素；
        TreeSet<Integer> treeSet = new TreeSet<>();
        //递归遍历将所有二叉树数值
        findAllEle(root, treeSet);
        if(treeSet.size() == 1)
        	return -1;
        //第一个为最小值，拿到这个最小值的第二个，不存在返回null；
        return treeSet.higher(treeSet.pollFirst());
	}
	
	public void findAllEle(TreeNode root,TreeSet<Integer> treeSet) {
		if(root != null) {
			findAllEle(root.left, treeSet);
			treeSet.add(root.val);
			findAllEle(root.right, treeSet);
		}
	
    }
}
