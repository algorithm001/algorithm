/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/submissions/
// 863. 二叉树中所有距离为k的结点
class Solution {
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList();
        
        // 1. 边界处理：如果树为空或目标节点为空，则直接返回空列表
        if(root==null || target == null){
            return list;
        }
                
        // 2. 存下每个节点到其父亲节点的映射。完整遍历二叉树做初始化。
        Map<TreeNode,TreeNode> parents = new HashMap();
        initParents(root,parents);
        
        // 3. 从 target 向下，找所有距离 target 为 k 的列表集合。
        findDepthK(target,k,list);
        
        // 4. 从 target 开始向上搜索。
        //    - 先找到父节点。
        //    - 如果父节点为null，则说明是根节点。不再继续找。
        //    - 如果 k==1 ，则只找到父节点就行了。不再继续找。
        //    - 如果当前节点是父节点的左子树，则去父节点的右子树上  findDepthK k-2，因为到父节点已经-1，再往下要再-1
        //    - 如果当前节点是父节点的右子树，则。。。。。。
        //    - 然后 k--，current 和 parent 再往上走一步。
        TreeNode current = target;
        TreeNode parent = parents.get(current);
        while(parent!=null){

            // 父节点null
            if(parent==null){
                break;
            }
            
            // k==1
            if(k==1){
                list.add(parent.val);
                break;
            }
            
            
            // 是父节点左子树
            if(parent.left == current){
                findDepthK(parent.right,k-2,list);
            }
            
            // 是父节点右子树
            if(parent.right == current){
                findDepthK(parent.left,k-2,list);
            }
            
            // 向上走一步继续找
            k--;
            current = parent;
            parent = parents.get(current);
        }
        return list;
    }
    
    // 初始化父节点映射表
    // 若当前节点为null，则什么都不做
    // 若左子树非空，则 add：左子树-根节点
    // 若右子树非空，则 add：右子树-根节点
    void initParents(TreeNode root,Map<TreeNode,TreeNode> parents){
        if(root==null){
            return;
        }
        if(root.left!=null){
            parents.put(root.left,root);
            initParents(root.left,parents);
        }
        if(root.right!=null){
            parents.put(root.right,root);
            initParents(root.right,parents);
        }
    }
    
    // 找 root 的 第 k 层所有节点。（不管target是啥）。其中，root是第0层。
    public void findDepthK(TreeNode root,int k,List<Integer> list){
        
        // root为空，则返回空列表
        if(root==null){
            return;
        }
        
        // k是0，则返回根节点
        if(k==0){
            list.add(root.val);
            return;
        }
        // k不是0，则去左右子树找 k-1 层的节点列表
        findDepthK(root.left,k-1,list);
        findDepthK(root.right,k-1,list);
        return;
    }
    
}
