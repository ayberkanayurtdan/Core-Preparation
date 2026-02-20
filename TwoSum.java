import java.util.HashMap;

class TwoSum {

  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer,Integer> hash= new HashMap<>();

    for(int i = 0; i<nums.length; i++){
      int complement =target-nums[i];
      if(hash.containsKey(complement))
          return new int[] {hash.get(complement),i};
      hash.put(nums[i],i);
        
    }
    return new int[] {};
  }
  
  //Test Verisi
  public static void main(String[] args){
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    
    int[] result = twoSum(nums, target); 
    System.out.println("[" + result[0] + ", " + result[1] + "]");
  }  
}