import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler {
    // Solve Task Scheduler with Greedy Math (Most Efficient) - Time: O(N) - Space: O(1)
    public int leastIntervalGreedyMath(char[] tasks, int n) {
        int[] taskCounts=new int[26];
        int maxF=0;
        int maxFCount=0;
        for(char task:tasks) taskCounts[task-'A']+=1;
        for(int count:taskCounts){
            if(count>maxF){
                maxF=count;
                maxFCount=1;
            }else if(count==maxF && count>0){
                maxFCount++;
            }
        }
        int totalTime=Math.max(((maxF-1)*(n+1)+maxFCount),tasks.length);
        return totalTime;
    }

    // Solve Task Scheduler with Max-Heap (Most Flexible) - Time: O(T log 26) - Space: O(1)
    public int leastIntervalMaxHeap(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue= new LinkedList<>();
        int[] taskCounts=new int[26];
        int time=0;
        for(char task:tasks) taskCounts[task-'A']+=1;
        for(int count:taskCounts){
            if(count>0) maxHeap.offer(count);
        }
        while(!maxHeap.isEmpty()||!queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int count=maxHeap.poll()-1;
                if(count>0){
                queue.offer(new int[]{count,time+n});
                }
            }
            if(!queue.isEmpty() &&queue.peek()[1]==time){
                maxHeap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
