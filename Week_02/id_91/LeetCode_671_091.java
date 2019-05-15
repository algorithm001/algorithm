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
        //思路：每个节点只能有两个孩子或者没有孩子
        //它小于等于它的孩子节点值，根节点时最小的节点
        //相当于找左右子孩子中不等于根节点且最小的一个
        //递归或者按层遍历
        Queue<TreeNode> queue=new LinkedList();
        queue.offer(root);
        TreeNode temp=root;
        int result=Integer.MAX_VALUE;
        boolean negativeFlag=false;
        while(!queue.isEmpty()){
            temp=queue.poll();

            if(temp.val>root.val&&temp.val<=result){
                result=temp.val;
                if(result==Integer.MAX_VALUE){
                    negativeFlag=true;
                }

            }
            if(temp.left!=null)queue.offer(temp.left);
            if(temp.right!=null)queue.offer(temp.right);

        }
        if(result==Integer.MAX_VALUE && !negativeFlag)return -1;
        return result;

    }
}