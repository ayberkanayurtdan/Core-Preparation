import java.util.HashMap;

public class CopyListWithRandomPointer {
    //Interweaving Approach (Highly Optimal) - Time: O(n), Space: O(1)
    public Node copyRandomList(Node head) {
        Node curr=head;
        
        while (curr!=null) {
            Node copy=new Node(curr.val);
            copy.next=curr.next;
            curr.next=copy;
            curr=copy.next;
        }

        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }

        curr=head;
        Node dummy= new Node(0);
        Node copyCurr=dummy;

        while(curr!=null){
            copyCurr.next=curr.next;
            curr.next=curr.next.next;

            copyCurr=copyCurr.next;
            curr=curr.next;
        }
        return dummy.next;
    }
    //HashMap (Brute Force) - Time: O(n), Space: O(n)
    public Node copyRandomListWithHashMap(Node head){
        HashMap<Node,Node> map=new HashMap<>();
        Node curr= head;

        while(curr!=null){
            map.put(curr,new Node(curr.val));
            curr=curr.next;
        }

        curr=head;
        while(curr!=null){
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }

        return map.get(head);
    }

    //Node class
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
