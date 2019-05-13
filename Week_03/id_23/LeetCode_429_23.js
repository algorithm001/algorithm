/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
  const result=[];
  const travel=(root,depth=0)=>{
      if(root===null){
          return;
      }
      if(!result[depth]){
            result[depth]=[];
      }
      result[depth].push(root.val);
      
      if(root.children){
          root.children.forEach(item=>{
            
              travel(item,depth+1);
              
          })
      }
  };
  travel(root);
  return result;
};