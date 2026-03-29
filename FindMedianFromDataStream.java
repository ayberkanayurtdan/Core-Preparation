import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream{
    // Two-Heap (Optimal) - Time Complexity: O(log N) for add, O(1) for find - Space Complexity: O(N)
    class MedianFinder {
        PriorityQueue<Integer> small=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> large=new PriorityQueue<>();
        public MedianFinder() {    
        }
        public void addNum(int num) {
            small.offer(num);
            large.offer(small.poll());
            if(large.size()>small.size()){
                small.offer(large.poll());
            }
        }
        
        public double findMedian() {
            if(small.size()>large.size()){
                return small.peek();
            }
            return (small.peek()+large.peek())/2.0;
        }
    }
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
