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
    int sum=0;
    //迭代法
    public int rangeSumBST(TreeNode root, int L, int R) {
       if(L > R) return 0;
       if(root == null) return 0;
       Stack<TreeNode> stack = new Stack<>();
       TreeNode cur = root;
       while(!stack.isEmpty() || cur != null){
           if(cur != null){
               stack.push(cur);
               cur = cur.left;
           }else{
               cur = stack.pop();
               if(cur.val >= L && cur.val <= R){
                   sum += cur.val;
               }
               cur = cur.right;
           }
           
       }
       return sum;
   }
   
   //递归
   //后序法
   public int rangeSumBST_1(TreeNode root, int L, int R) {
       if(root!=null){
           if(root.left!=null){
              rangeSumBST(root.left,L,R);
           }
           if(root.right!=null){
              rangeSumBST(root.right,L,R);
           } 
              if(root.val>=L&&root.val<=R){
               sum+=root.val;
           }
       }
       return sum;
   }
   
   //中序法
   public int rangeSumBST0(TreeNode root, int L, int R) {
       if(root!=null){
           if(root.left!=null){
              rangeSumBST(root.left,L,R);
           }
             if(root.val>=L&&root.val<=R){
               sum+=root.val;
           }
           if(root.right!=null){
              rangeSumBST(root.right,L,R);
           } 
       }
      return sum;
   }
   
  
   //前序法
   public int rangeSumBST1(TreeNode root, int L, int R) {
       if(root!=null){
           if(root.val>=L&&root.val<=R){
               sum+=root.val;
           } 
           
          rangeSumBST(root.left,L,R);
              
           rangeSumBST(root.right,L,R); 
               
       }
      return sum;
   }
   
   //前序法
    public int rangeSumBST2(TreeNode root, int L, int R) {
       int sum=0;
       if(root!=null){
           if(root.val>=L&&root.val<=R){
               sum+=root.val;
           }
           if(root.left!=null){
               sum+=rangeSumBST(root.left,L,R);
           }
           if(root.right!=null){
               sum+=rangeSumBST(root.right,L,R);
           } 
       }
      return sum;
   }
}