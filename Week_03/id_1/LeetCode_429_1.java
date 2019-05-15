class Solution {
private List<List<Integer>> result = new ArrayList<>();

   public List<List<Integer>> levelOrder(Node root) {

       if (root == null) {
           return result;
       }

       List<Integer> nodeVals = new ArrayList<>();
       nodeVals.add(root.val);
       result.add(nodeVals);
       this.bfs(root.children);
       return this.result;

   }

   public void bfs(List<Node> nodes) {
       int length = nodes.size();
       if (length == 0) {
           return;
       }

       List<Node> childrens = new ArrayList<>();
       List<Integer> nodeVals = new ArrayList<>();

       for (int i = 0; i < length; i ++) {
           Node node = nodes.get(i);
           nodeVals.add(node.val);

           if (node.children != null) {
               Iterator<Node> iterator = node.children.iterator();
               while (iterator.hasNext()) {
                   childrens.add(iterator.next());
               }
           }

       }

       this.result.add(nodeVals);
       this.bfs(childrens);
   }
}