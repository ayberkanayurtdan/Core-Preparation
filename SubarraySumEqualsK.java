import java.util.HashMap;

public class SubarraySumEqualsK {
    //Prefix Sum & HashMap (Optimal) - Time Complexity= O(n) - Space Complexity= O(n)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int count=0;
        int currentSum=0;
        HashMap<Integer,Integer> map= new HashMap<>();

        map.put(0,1);

        for (int num:nums){
            currentSum+=num;
            if(map.containsKey(currentSum-k)){
                count+=map.get(currentSum-k);
            }
            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
    //Nested Loops - Time Complexity= O(n^2) - Space Complexity= O(1)
    public int subarraySumBruteForce(int[] nums, int k) {
        if (nums==null || nums.length==0) return 0;
        int count=0;

        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int currentSum=nums[i];
            if(currentSum==k) count++;
            while(j<nums.length){
                currentSum+=nums[j];
                if(currentSum==k){
                    count++;
                }
                j++;
            }
        }
        return count;
    }
}
