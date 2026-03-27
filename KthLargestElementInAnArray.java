import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInAnArray {
    // QuickSelect Approach (Optimal) - Time Complexity: O(n) average O(n^2) worst case- Space Complexity: O(1)
    private Random random=new Random();
    public int findKthLargest(int[] nums, int k) {
        int targetIndex=nums.length-k;
        return quickSelect(nums,0,nums.length-1,targetIndex);
    }
    private int quickSelect(int[] nums, int left, int right, int target){
        if(left==right) return nums[left];
        int randomIndex=left+random.nextInt(right-left+1);
        swap(nums, randomIndex, right);
        int pivotIndex=partition(nums,left,right);
        if(pivotIndex==target){
            return nums[target];
        }else if(pivotIndex<target){
            return quickSelect(nums,pivotIndex+1,right,target);
        }else{
            return quickSelect(nums,left,pivotIndex-1,target);
        }
    }

    private int partition(int[] nums, int left, int right){
        int pivot=nums[right];
        int i=left;
        for(int j=left;j<right;j++){
            if(nums[j]<=pivot){
                swap(nums,i,j);
                i++;
            }
        }
        swap(nums,i,right);
        return i;
    }
    private void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    // Min-Heap Approach (Optimal) - Time Complexity: O(n log k) - Space Complexity: O(k)
    public int findKthLargestUsingMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            minHeap.offer(nums[i]);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
