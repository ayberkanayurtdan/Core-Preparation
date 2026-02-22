public class MergeTwoSortedLists {
      
    // Optimal - Time complexity: O(N+M) - Space complexity: O(1) - Neither
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy=new ListNode(0);
        ListNode current = dummy;

        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                current.next=list1;
                list1=list1.next;
            }else{
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }
        if(list1!=null){
            current.next=list1;
        }
        if(list2!=null){
            current.next=list2;
        }

        return dummy.next;
    }
    // Stack Risk - Time complexity: O(N+M) - Space complexity: O(N+M) - Stack
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        if(list1.val<list2.val){
            list1.next=mergeTwoListsRecursive(list1.next, list2);
            return list1;
        }else{
            list2.next=mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }
    // Memory Heavy - Time complexity: O(N+M) - Space complexity: O(N+M) - Heap
    public ListNode mergeTwoListsWithNewLinkedList(ListNode list1, ListNode list2) {
        ListNode dummy= new ListNode(0);
        ListNode current=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                current.next= new ListNode(list1.val);
                list1=list1.next;
            }else{
                current.next= new ListNode(list2.val);
                list2=list2.next;
            }
            current=current.next;
        }
        if(list1!=null){
            current.next=list1;
        }
        if(list2!=null){
            current.next=list2;
        }

        return dummy.next;
    }
    //Test Verisi
    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        // 1. Optimal
        ListNode list1 = new ListNode(1, new ListNode(5));
        ListNode list2 = new ListNode(2, new ListNode(4));
        ListNode res1 = solution.mergeTwoLists(list1, list2);
        
        System.out.print("Optimal: ");
        while (res1 != null) { System.out.print(res1.val + "->"); res1 = res1.next; }
        System.out.println("null");

        // 2. Recursive
        list1 = new ListNode(1, new ListNode(5));
        list2 = new ListNode(2, new ListNode(4));
        ListNode res2 = solution.mergeTwoListsRecursive(list1, list2);
        
        System.out.print("Recursive: ");
        while (res2 != null) { System.out.print(res2.val + "->"); res2 = res2.next; }
        System.out.println("null");

        // 3. New Node
        list1 = new ListNode(1, new ListNode(5));
        list2 = new ListNode(2, new ListNode(4));
        ListNode res3 = solution.mergeTwoListsWithNewLinkedList(list1, list2);
        
        System.out.print("Memory Heavy: ");
        while (res3 != null) { System.out.print(res3.val + "->"); res3 = res3.next; }
        System.out.println("null");
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


