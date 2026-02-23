import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElement {

    @SuppressWarnings("unchecked")  // To disable generic array warnings.


    //HashMap and Bucket Sort (Optimal) - Time Complexity: O(n) - Space Complexity: O(n)
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int[] mostFrequent = new int[k];

        for(int i=0; i<nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i],0)+1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(int c:counter.keySet()){
            int freq = counter.get(c);

            if(bucket[freq]==null) bucket[freq] = new ArrayList<>();
            bucket[freq].add(c);
        }
        int index=0;
        for(int i = bucket.length-1;i>=0 && index<k;i--){
            if(bucket[i]==null) continue;
            for(int num:bucket[i]){
                mostFrequent[index]=num;
                index++;

                if (index == k) break;
            }     
        }
        return mostFrequent;
    }
    //HashMap and Sorting - Time Complexity: O(n log n) - Space Complexity: O(n)
    public int[] topKFrequentWithSorting(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int[] mostFrequent = new int[k];

        for(int i=0; i<nums.length; i++){
            counter.put(nums[i], counter.getOrDefault(nums[i],0)+1);
            /*if(!counter.containsKey(nums[i])){
                counter.put(nums[i],0);
            }
            counter.put(nums[i],counter.get(nums[i])+1);*/
        }

        List<Integer> keyList=new ArrayList<>(counter.keySet());
        keyList.sort(Comparator.comparing(counter::get).reversed());

        for(int i =0; i<k; i++){
            mostFrequent[i]=keyList.get(i);
        }

        return mostFrequent;
    }

    //Test Verisi
    public static void main(String[] args) {
    TopKFrequentElement sol = new TopKFrequentElement();
    int[] nums = {1, 1, 1, 2, 2, 3};
    int k = 2;

    // Test for Bucket Sort (Optimal)
    int[] res1 = sol.topKFrequent(nums, k);
    System.out.println("Bucket Sort Result: " + java.util.Arrays.toString(res1));

    // Test for Sorting Method
    int[] res2 = sol.topKFrequentWithSorting(nums, k);
    System.out.println("Sorting Result: " + java.util.Arrays.toString(res2));
    }
}
