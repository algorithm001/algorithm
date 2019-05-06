

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Output.printf(Solution.maxDepth(Input.getBinaryTree()));
        /*int N = Input.getN();
        Output.printf(Solution.findJudge(N, Input.getTrust()));
        */
    }

}



class Solution {
    static int findJudge(int N, int[][] trust) {
        if (trust.length < N - 1)   return -1;
        int[] people = new int[N];
        List<Integer> judge = new LinkedList<>();
        for (int i = 0; i < people.length; i++){
            people[i] = i;
        }   //initialization
        for (int i = 0; i < trust.length; i++){
            people[trust[i][0] - 1] = -1;
        }
        for (int i = 0; i < people.length; i++){
            if (people[i] != -1)    judge.add(people[i]);
        }
        if (judge.size() != 1)  return -1;  //JC:judge contains one element.

        for (int i = 0; i < people.length; i++){
            people[i] = i;
        }   //initialization
        for (int i = 0; i < trust.length; i++){
            if (trust[i][1] == judge.get(0) + 1)    people[trust[i][0] - 1] = -1;
        }
        int count = 0;
        for (int i = 0; i < people.length; i++){
            if (people[i] == -1)    count++;
        }
        if (count == N-1)   return judge.get(0) + 1;
        else return -1;
    }
    static private int max(int x, int y){
        return x > y ? x : y;
    }
    static int maxDepth(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null)    return 1;
        return max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

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
    static int getN(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    static int[][] getTrust(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] trust = new int[N][2];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < 2; j++){
                trust[i][j] = sc.nextInt();
            }
        }
        return trust;
    }
}

