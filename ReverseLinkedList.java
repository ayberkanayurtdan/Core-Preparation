import java.util.ArrayList;
import java.util.Collections;


public class ReverseLinkedList {

    //  Maximum efficiency & best performance. - Time Complexity: O(n) - Space Complexity: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr=head;

        while(curr!=null){
            ListNode nextTemp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTemp;
        }
        return prev;
    }
    // Slow execution & minimal memory usage - Time Complexity: O(n^2) Space Complexity: O(1)
    public ListNode reverseListBruteForce(ListNode head) {
        if (head == null || head.next==null) return null;
        
        int count=0;
        ListNode prev, curr= head, newHead=head;

        while(curr!=null){
            count++;
            if(curr.next==null){
                newHead=curr;
            }
            curr=curr.next;
        } 
        while(count>1){
            curr=head;
            prev=head;

            for(int i=0;i<count-1;i++){
                prev=curr;
                curr=curr.next;
            }
            curr.next=prev;
            count--;
        }
        head.next=null;
        
        return newHead;
    }
    // Fast execution & high memory overhead - Time Complexity: O(n) -  Space Complexity: O(n)
    public ListNode reverseListWithIntegerArray(ListNode head) {
        if (head == null) return null;
        
        ListNode node= head;
        ArrayList<Integer> values= new ArrayList<Integer>();

        while(node!=null){
            values.add(node.val);
            node=node.next;
        }

        Collections.reverse(values);
        node=head;
        for(int i=0; i<values.size();i++){
            node.val=values.get(i);
            node=node.next;
        }

        return head;
    }

    //Test Data
    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();
        // 1 -> 2 -> 3
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));

        System.out.print("Original: ");
        for (ListNode n = head; n != null; n = n.next) System.out.print(n.val + " ");
        
        // 1. Optimal
        head = sol.reverseList(head);
        System.out.print("\nOptimal: ");
        for (ListNode n = head; n != null; n = n.next) System.out.print(n.val + " ");
        head = sol.reverseList(head); // reverse for test again

        // 2. Brute Force
        head = sol.reverseListBruteForce(head);
        System.out.print("\nBrute Force: ");
        for (ListNode n = head; n != null; n = n.next) System.out.print(n.val + " ");
        head = sol.reverseList(head); // reverse for test again

        // 3. ArrayList Way
        head = sol.reverseListWithIntegerArray(head);
        System.out.print("\nArrayList Way: ");
        for (ListNode n = head; n != null; n = n.next) System.out.print(n.val + " ");
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
