package com.imooc.activiti.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author shironghui on 2019/4/18.
 */
class Solution10 {

    //暴力搜索法
    public void dfs(TreeNode root,Set<Integer> unique){
        if(root!=null){
            unique.add(root.val);
            dfs(root.left,unique);
            dfs(root.right,unique);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        if(root!=null){
            Set<Integer> unique=new HashSet<>();
            dfs(root,unique);
            int min1=root.val;
            long ans=Long.MAX_VALUE;
            for(int v:unique){
                if(min1<v&&v<ans){
                    ans=v;
                }
            }
            return (ans==Long.MAX_VALUE)?-1:(int)ans;
        }
        return -1;
    }

}

public class TestBinaryTree2 {
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Solution10().findSecondMinimumValue(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
