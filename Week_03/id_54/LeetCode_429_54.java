class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root,res,0);
        return res;
    }
    
    private void helper(Node root, List<List<Integer>> res, int depth){
        if(root==null)
            return;
        if(res.size()-1<depth)
            res.add(new ArrayList<Integer>());
        res.get(depth).add(root.val);
        for(int i=0;i<root.children.size();i++)
            helper(root.children.get(i),res,depth+1);
    } 
}
