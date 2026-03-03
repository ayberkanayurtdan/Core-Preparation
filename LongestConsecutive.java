import java.util.Arrays;

public class LongestConsecutive {

    //Sorting (Optimal) - Time Complexity= O(n log n) - Space Complexity= O(1)
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Arrays.sort(nums);

        int currentConsecutive=1;
        int max=1;
        for(int i=0;i<nums.length-1;i++){
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if(nums[i]==nums[i+1]-1){
                currentConsecutive++;
            }else{
                currentConsecutive=1;
            }
            max=Math.max(max,currentConsecutive);
        }
        return max;
    }
}
