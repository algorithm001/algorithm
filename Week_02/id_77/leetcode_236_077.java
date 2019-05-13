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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> res  = new ArrayList<TreeNode>(3);
        
        return preorderTraversal(root,p,q,res).get(2);
    }
    
    public List<TreeNode> preorderTraversal(TreeNode root,TreeNode p,TreeNode q,List<TreeNode> res){
        if(root == null ){
            return res;
        }

        if(root.val == p.val || root.val == q.val){
           res.add(root);
           if(res.size()>1){
               return res;
           }
         
           preorderTraversal(root.left,p,q,res);
           if(res.size()>1){
                res.add(root);
               return res;
           }
           preorderTraversal(root.right,p,q,res);
            if(res.size()>1){
                res.add(root);
               return res;
           }
        return res;

        }  
        
        if(res.size() == 0){
            preorderTraversal(root.left,p,q,res);
            if(res.size() ==1 ){
                preorderTraversal(root.right,p,q,res).size();
                if(res.size()==2){
                    res.add(root);
                    return res;
                }
            }
             return preorderTraversal(root.right,p,q,res); 
           
        }else {
            if(preorderTraversal(root.left,p,q,res).size() > 1){
                return res;
            }
            if(preorderTraversal(root.right,p,q,res).size()>1){
                return res;
            }
                   
        }   

    return res;     
        
    }

}