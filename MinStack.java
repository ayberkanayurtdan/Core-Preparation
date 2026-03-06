public class MinStack {
    // MinStack with Node (Optimal) - Time Complexity: O(1) - Space Complexity: O(n)
    private class Node{
        int val;
        int min;
        Node next;

        Node(int val, int min, Node next){
            this.val=val;
            this.min=min;
            this.next=next;
        }
    }

    private Node head;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if(head==null){
            head = new Node(val,val,null);
        }else{
            head= new Node(val,Math.min(val,head.min),head);
        }
    }
    
    public void pop() {
        if(head!=null){
            head=head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}