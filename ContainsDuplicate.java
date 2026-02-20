import java.util.HashSet;
class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueValues=new HashSet<>();

        for (int number : nums){
            if(!uniqueValues.add(number))
                return true;
        }
        return false;
    }

    //Test Verisi
    public static void main(String[] args) {
        ContainsDuplicate solver = new ContainsDuplicate();
        
        int[] case1 = {1, 2, 3, 1};
        System.out.println("Case1 Result: " + solver.containsDuplicate(case1));

        int[] case2 = {1, 2, 3, 4};
        System.out.println("Case2 Result: " + solver.containsDuplicate(case2));

        int[] case3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Case3 Result: " + solver.containsDuplicate(case3));
    }
}