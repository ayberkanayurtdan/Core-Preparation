import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    // Max-Heap Approach (Optimal for Streams) - Time Complexity: O(n log k) - Space Complexity: O(k)
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b) ->
        (b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1]));

        for(int[] point:points){
            maxHeap.offer(point);
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }
        int[][] result=new int[k][2];
        while(k>0){
            result[--k]=maxHeap.poll();
        }
        return result;
    }
}
