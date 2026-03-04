public class MiddleOfTheLinkedList {
    // Floyd's Tortoise and Hare (Optimal) - Time Complexity= O(n) - Space Complexity= O(1)
    public ListNode middleNode(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        
        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
