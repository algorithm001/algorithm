package com.imooc.activiti.helloworld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shironghui on 2019/4/18.
 */
class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current=head;
        while(current!=null&&current.next!=null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
        return head;
    }
}
public class TestSort {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        //generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
        //Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ",";
            node = node.next;
        }
        String substring = result.substring(0, result.length() - 1);
        return "[" +  substring+ "]";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);
            ListNode ret = Solution.deleteDuplicates(head);
            String out = listNodeToString(ret);
            System.out.println(out);
        }


//        ListNode listNodeOne=new ListNode(1);
//        ListNode listNodeTwo=new ListNode(1);
//        ListNode listNodeThree=new ListNode(2);
//        listNodeOne.next=listNodeTwo;
//        listNodeOne.next.next=listNodeThree;
//        ListNode listNode = Solution.deleteDuplicates(listNodeOne);
//        if(listNode.next==null){
//
//        }
//    }
    }
}
