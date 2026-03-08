public class FindMinimumInRotatedSortedArray {
    //Binary Search (Optimal) - Time Complexity: O(log n) - Space Complexity: O(1)
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int middle=left+(right-left)/2;
            
            if(nums[middle]>nums[right]){
                left=middle+1;    
            }else{
                right=middle;
            }
        }
        return nums[left];
    }
    //Linear Scan (Brute Force) - Time Complexity: O(n) - Space Complexity: O(1)
    public int findMinBruteForce(int[] nums) {
        int min=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<min){
                min=nums[i];
            }
        }   
        return min;
    }
}
