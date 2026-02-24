public class ProductOfArrayExceptSelf {
    //Prefix and Suffix (Optimal) - Time Complexity: O(n) - Space Complexity: O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] result=new int[nums.length];

        result[0]=1;
        for(int i=1;i<nums.length;i++){
            result[i]=result[i-1]*nums[i-1];
        }

        int suffixProduct=1;
        for(int i=nums.length-1;i>=0;i--){
            result[i]=result[i]*suffixProduct;
            suffixProduct*=nums[i];
        }
        return result;
    }
    //Brute Force - Time Complexity: O(n^2) - Space Complexity: O(1)
    public int[] productExceptSelfx(int[] nums) {
        int[] productList= new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int product=1;
            for(int j=0;j<nums.length;j++){
                if(i!=j){
                    product*=nums[j];
                }
            }
            productList[i]=product;
        }

        return productList;
        
    }


}
