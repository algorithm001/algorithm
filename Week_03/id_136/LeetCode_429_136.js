/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function(root) {
    var res = [];
    function bfs(tree, idx){
        if(!tree) return;
        if(!Array.isArray(res[idx])){
            res[idx] = [];
        }
        res[idx].push(tree.val);
        if(tree.children.length > 0){
            for(var i=0;i<tree.children.length;i++){
                bfs(tree.children[i], idx+1);
            }
        }
    }
    bfs(root, 0);
    return res;
};