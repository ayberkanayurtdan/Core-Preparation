public class RemoveNthNodeFromEndOfList {
    //Two Pointers (Highly Optimal) - Time Complexity= O(n) - Space Complexity= O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode left=dummy,right=dummy;

        for(int i=0;i<=n;i++){
            right=right.next;
        }
        while(right!=null){
            left=left.next;
            right=right.next;
        }
        left.next=left.next.next;
        return dummy.next;
    }
}
