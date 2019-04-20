
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Output.printf(Solution.deleteDuplicates(Input.getHeadList().getHead()));
//        Output.printf(Solution.mergeTwoLists(Input.getHeadList().getHead(),Input.getHeadList().getHead()));
//        Output.printf(Solution.swapPairs(Input.getHeadList().getHead()));
//        HeadList list = Input.getHeadList();
//        Output.printf(HeadList.searchNode(Solution.detectCycle(HeadList.createCycle(Input.getPositionOrK(),list)),list));
//        Output.printf(Solution.reverseKGroup(Input.getHeadList().getHead(),Input.getPositionOrK()));


    }

}

/*      Here is Interface class
        Name:   ListNode
 */
class Solution{
    static HeadList.ListNode deleteDuplicates(HeadList.ListNode head) {
        Map<Integer,HeadList.ListNode> map = new HashMap<>();
        HeadList.ListNode tmp = head;
        while (tmp != null){  //JC:   tmp.next == null
            if(map.get(tmp.val) == null){  //JC:   map.get() return something
                map.put(tmp.val,tmp);
            }
            else HeadList.delete(head,tmp);
            tmp = tmp.next;
        }
        return head;
    }
    static HeadList.ListNode mergeTwoLists(HeadList.ListNode l1, HeadList.ListNode l2){
        HeadList list = new HeadList();
        HeadList.ListNode tmp1 = l1.next;   //because of head node.
        HeadList.ListNode tmp2 = l2.next;
        while (true){
            if (tmp1 == null){
                for( ; tmp2 != null; tmp2 = tmp2.next){
                    list.insert(tmp2.val);
                }
                break;
            }
            else if (tmp2 == null){
                for( ; tmp1 != null; tmp1 = tmp1.next){
                    list.insert(tmp1.val);
                }
                break;
            }
            else if (tmp1.val > tmp2.val){
                list.insert(tmp2.val);
                tmp2 = tmp2.next;
            }
            else {
                list.insert(tmp1.val);
                tmp1 = tmp1.next;
            }
        }
        return list.getHead();
    }
    static HeadList.ListNode swapPairs(HeadList.ListNode head){
        HeadList.ListNode pre, tmp, tail;
        pre = head;
        while (true){
            if (pre.next == null)   break;
            if (pre.next.next == null)  break;
            tmp = pre.next;
            tail = pre.next.next.next;
            pre.next = pre.next.next;
            pre.next.next = tmp;
            tmp.next = tail;
            pre = pre.next.next;
        }
        return head;
    }
    static HeadList.ListNode detectCycle(HeadList.ListNode head){
        Map<HeadList.ListNode,Integer> map = new HashMap<>();
        HeadList.ListNode tmp = head;
        int pos = 0;
        while (tmp != null){    //JC:   tmp.next == null
            if (map.get(tmp) == null){  //JC:   map.get() return something
                map.put(tmp,pos);
                tmp = tmp.next;
                pos++;
            }
            else break;
        }
        return tmp;
    }
    static HeadList.ListNode reverseKGroup(HeadList.ListNode head, int k){
        if(k == 1 || k == 0) return head;
        HeadList.ListNode detect, pre, segPre, segTmp, tail, tailNext;
        if (head.next == null)  return head;
        segPre = head;
        detect = pre = segTmp = head.next;
        if (head.next.next == null) return head;
        tail = pre.next;
        tailNext = tail.next;
        while (true){
            int i = 0;
            for ( ; i < k; i++){
            if (detect == null){
                segPre.next = tailNext;
                return head;
            }
            else detect = detect.next;
            }
            for (int j = 0; j < k - 1; j++){    //K-1:N elements need N reverses.
                tail.next = pre;
                pre = tail;

                tail = tailNext;
                if (tailNext != null)  tailNext = tailNext.next;

            }
            segPre.next = pre;
            pre = tail;
            tail = tailNext;
            if (tailNext != null)  tailNext = tailNext.next;
            segPre = segTmp;
            segTmp = pre;
        }
    }
}


/*      Here is Supporting class
        Name:   HeadList
 */
class HeadList{
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    private ListNode head;

    HeadList() {
        head = new ListNode(Integer.MIN_VALUE);
    }

    ListNode getHead(){
        return this.head;
    }
    static boolean delete(ListNode head,ListNode node){
        if (head == null || node == null)    return false;
        ListNode tmp = head;
        while (tmp.next != node && tmp.next != null){   //JC:   tmp.next == node || tmp.next == null
            tmp = tmp.next;
        }
        if (tmp.next == node){
            tmp.next = node.next;
            return true;
        }
        else return false;
    }
    void insert(int x){
        ListNode tmp = new ListNode(x);
        ListNode tail = head;
        while (tail.next !=null){
            tail = tail.next;
        }
        tail.next = tmp;
    }
    static ListNode createCycle(int pos, HeadList list){
        ListNode tail = list.head;
        while (tail.next !=null){   //get tail node.
            tail = tail.next;
        }
        ListNode pre = list.head;
        while (true){
            for (int i = 0; i < pos+1; i++){ //because of the head node.
                pre = pre.next;
            }
            break;
        }
        tail.next = pre;
        return list.head;
    }
    static int searchNode(ListNode node, HeadList list){
        ListNode tmp = list.head;
        int index = 0;
        while (node != tmp){    //JC:   node == tmp
            if (tmp != null){
                tmp = tmp.next;
                index++;
            }
            else return -1;
        }
        return index - 1;
    }


}


/*      Here is Interface class
        Name:   Output Input
 */
class Output{
    static void printf(HeadList.ListNode head){
        HeadList.ListNode tmp = head;
        while (tmp.next != null){
            System.out.print(tmp.next.val);
            tmp = tmp.next;

        }
    }
    static void printf(int val){
        System.out.print(val);
    }
}
class Input{
    static HeadList getHeadList(){
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++){
            array[i] = sc.nextInt();
        }
        HeadList list = new HeadList();
        for (int i : array){
            list.insert(i);
        }
        return list;
    }
    static int getPositionOrK(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}

