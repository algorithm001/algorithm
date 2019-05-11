

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Output.printf(Solution.findSecondMinimumValue(Input.getBinaryTree()));
/*        BinaryTree.TreeNode root = Input.getBinaryTree();
        int p = Input.getPositionOrK();
        int q = Input.getPositionOrK();
        Output.printf(Solution.lowestCommonAncestor(root, BinaryTree.findNode(root, p), BinaryTree.findNode(root, q)).val);
        */




    }

}



class Solution {

    static int findSecondMinimumValue(BinaryTree.TreeNode root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Integer.MAX_VALUE);
        queue.add(Integer.MAX_VALUE);
        Stack<BinaryTree.TreeNode> s = new Stack<>();
        BinaryTree.TreeNode p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                if (p.val < queue.peek()) {
                    int head = queue.poll();       //get the head.
                    if (p.val > queue.peek()) {
                        int tmp = queue.poll();
                        queue.add(p.val);
                        queue.add(tmp);
                    } else if (p.val < queue.peek()) {
                        queue.add(p.val);
                    } else {
                        queue.add(head);
                        int tmp = queue.poll();
                        queue.add(tmp);
                    }

                }
                s.push(p);
                p = p.left;
            }
            p = s.pop();
            p = p.right;
        }
        if (queue.peek() == Integer.MAX_VALUE) return -1;
        else return queue.poll();
    }

    static BinaryTree.TreeNode lowestCommonAncestor(BinaryTree.TreeNode root, BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
        if (root == p)  return p;
        if (root == q)  return q;
        if (root.left != null && root.right != null){
            if ((BinaryTree.isHave(root.left, p) && BinaryTree.isHave(root.right, q)) || (BinaryTree.isHave(root.right, p) && BinaryTree.isHave(root.left, q))) return root;
            if (BinaryTree.isHave(root.left, p) && BinaryTree.isHave(root.left, q)) return lowestCommonAncestor(root.left, p, q);
            if (BinaryTree.isHave(root.right, p) && BinaryTree.isHave(root.right, q)) return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }

/*    public List<Integer> distanceK(BinaryTree.TreeNode root, BinaryTree.TreeNode target, int K) {
        List<Integer> list = new ArrayList<>();

        if(root==null) return null;
        Queue<BinaryTree.TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            BinaryTree.TreeNode temp =  q.poll();
            temp
            if(temp.left!=null)q.add(temp.left);
            if(temp.right!=null)q.add(temp.right);
        }


    }
    */
}


/*      Here is Supporting class
        Name:   BinaryTree
 */
class BinaryTree{
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private TreeNode root;
    BinaryTree(){
        root = null;
    }
    BinaryTree(TreeNode node){
        root = node;
    }

    static TreeNode creatTree(int[] array, int index){
        TreeNode root = new TreeNode(array[index]);
        if(2 * index + 1 < array.length && array[2 * index + 1] != -1) { //Array boundary judgement.
            root.left = creatTree(array, 2 * index + 1);
        }
        if (2 * index + 1 < array.length && array[2 * index + 2] != -1) {
            root.right = creatTree(array, 2 * index + 2 );
        }
        return root;
    }
    static TreeNode findNode(TreeNode root, int key){
        TreeNode node = null;
        if (root.val == key) node = root;
        if (node == null && root.left != null) node = findNode(root.left, key);
        if (node == null && root.right != null) node = findNode(root.right, key);
        return node;
    }
    static Boolean isHave(TreeNode root, TreeNode node){
        Boolean flagLeft, flagRight;
        flagLeft = flagRight = false;
        if (root == node)   return true;
        if (root.left != null)  flagLeft = isHave(root.left, node);
        if (root.right != null) flagRight = isHave(root.right, node);
        return flagLeft | flagRight;
    }


}


/*      Here is Interface class
        Name:   Output Input
 */
class Output{
/*    static void printf(HeadList.ListNode head){
        HeadList.ListNode tmp = head;
        while (tmp.next != null){
            System.out.print(tmp.next.val);
            tmp = tmp.next;

        }
    }
    */
    static void printf(int val){
        System.out.print(val);
    }
}

/*      Here is Interface class
        Name:   ListNode
 */
class Input{
    static BinaryTree.TreeNode getBinaryTree(){
        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        int[] array = new int[(int)Math.pow(2,level) - 1];
        for (int i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
        }
        return BinaryTree.creatTree(array, 0);
    }
    static int getPositionOrK(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}

