import java.util.PriorityQueue;

public class MergeKSortedLists {
    //PriorityQueue (Min-Heap) - Time: O(N log k), Space: O(k)
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val - b.val);
        ListNode dummy= new ListNode(0);
        ListNode tail= dummy;

        for(ListNode node:lists){
            if(node!=null){
                pq.add(node);
            }
        }
        while(!pq.isEmpty()){
            ListNode node=pq.poll();
            if (node.next != null) { 
                pq.add(node.next);
            }
            tail.next=node;
            tail=tail.next;
        }

        return dummy.next;
    }

    @SuppressWarnings("unused") //just suppress the warning
    //ListNode Class
    private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
