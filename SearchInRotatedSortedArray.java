public class SearchInRotatedSortedArray {
    //Binary Search (Optimal) - Time: O(log n) - Space: O(1)
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        
        while(left<=right){
            int middle= left+(right-left)/2;
            if (nums[middle] == target) return middle;

            if (nums[left]<=nums[middle]){
                if(nums[left]<=target && nums[middle]>target){
                    right=middle-1;
                }else{
                    left=middle+1;
                }
            }else{
                if(nums[right]>=target && nums[middle]<target){
                    left=middle+1;
                }else{
                    right=middle-1;
                }
            }
        }
        return -1;
    }
}
