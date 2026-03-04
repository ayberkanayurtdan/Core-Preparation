public class ReorderList {
    //Slow/Fast Pointers, Reverse, and Merge (Highly Optimal) - Time Complexity=O(n) - Space Complexity=O(1)
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode secondHalf = slow.next;
        slow.next=null;

        ListNode prev=null, curr=secondHalf;
        while(curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        ListNode left=head, right=prev;
        while(right!=null){
            ListNode tempNode=left.next;
            left.next=right;
            left=tempNode;

            tempNode= right.next;
            right.next=left;
            right=tempNode;
        }
    }
}
