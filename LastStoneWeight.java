import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    // Max-Heap Approach (Optimal) - Time Complexity: O(n log n) - Space Complexity: O(n)
    public int lastStoneWeight(int[] stones) {
        if(stones==null) return 0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int stone:stones){
            maxHeap.offer(stone);
        }
        while(maxHeap.size()>1){
            int x=maxHeap.poll();
            int y=maxHeap.poll();
            if(x-y!=0) maxHeap.offer(x-y);
        }
        return maxHeap.isEmpty() ? 0:maxHeap.peek();
    }
}
