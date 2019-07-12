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
    private int min = 100;
    private List<Integer> list = new ArrayList<>();
    
    public int minDiffInBST(TreeNode root) {
        //利用二叉搜索树中序遍历是递增序列的特点计算，相邻两个数的差值，选出最小值
        toList(root);
        
        if(list.size() == 0) return 0;
        if(list.size() == 1) return list.get(0);
        
        //循环遍历通过比较拿到最小差值
        for(int i = 0;i<list.size()-1;i++){
            min = Math.min(min, list.get(i+1)-list.get(i));
        }
        return min;
    }
    
    public void toList(TreeNode node ){
        if(node == null) return ;
        toList(node.left);
        list.add(node.val);
        toList(node.right);
    }
}
