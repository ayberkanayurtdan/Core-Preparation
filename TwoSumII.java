import java.util.HashMap;

public class TwoSumII {
    //Two Pointers (Optimal if int[] sorted) - Time Complexity: O(n) - Space Complexity: O(1)
    public int[] twoSumTwoPointers(int[] numbers, int target) {
        int l=0, r=numbers.length-1;

        while(l<r){
            int sum=numbers[l]+numbers[r];
            if(sum>target) r--;
            if(sum<target) l++;
            if(sum==target) break;
        }

        return new int[] {l+1,r+1};
    }
    //HashMap (Optimal if int[] unsorted) - Time Complexity: O(n) - Space Complexity: O(n)
    public int[] twoSumHashMap(int[] numbers, int target) {
        HashMap<Integer,Integer> hash= new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            int difference= target-numbers[i];
            if(hash.containsKey(difference)){
                return new int[] {hash.get(difference),i+1};
            }
            hash.put(numbers[i],i+1);
        }
        return new int[] {};
    }
}
