import java.util.HashSet;

public class LinkedListCycle {

    //Two Pointers (Optimal) - Time Complexity: O(n) - Space Complexity: O(1)
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    //Hash Set (Extra Memory)- Time Complexity: O(n) - Space Complexity: O(n)
    public boolean hasCycleWithHashset(ListNode head) {
        if(head==null || head.next==null) return false;
        HashSet<ListNode> visitedNodes= new HashSet<ListNode>();
        while(head!=null){
            if(visitedNodes.add(head)){
                head=head.next;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();

        // 1. Test Senaryosu: Döngü VAR (1 -> 2 -> 3 -> 2...)
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        head1.next = node2;
        node2.next = node3;
        node3.next = node2; // Döngü

        System.out.println("--- Test 1: Döngülü Liste ---");
        System.out.println("Two Pointers: " + solution.hasCycle(head1));
        System.out.println("Hash Set: " + solution.hasCycleWithHashset(head1));

        // 2. Test Senaryosu: Döngü YOK (10 -> 20 -> 30 -> null)
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);

        System.out.println("\n--- Test 2: Döngüsüz Liste ---");
        System.out.println("Two Pointers: " + solution.hasCycle(head2));
        System.out.println("Hash Set: " + solution.hasCycleWithHashset(head2));
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
