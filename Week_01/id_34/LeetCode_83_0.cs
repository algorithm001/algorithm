    public class Solution
    {
        public ListNode DeleteDuplicates(ListNode head)
        {
            int currentValue = head.val;
            int nextValue = 0;

           
            if(head == null|| head.next==null)
            { return head; }

            ListNode copyHead = head;
            while(copyHead.next!=null)
            {
                currentValue = copyHead.val;
                nextValue = copyHead.next.val;
                if(currentValue==nextValue)
                {
                    copyHead.next = copyHead.next.next;
                }
                else
                {
                    copyHead = copyHead.next;
                }
            }

            return head;
        }
    }
