public class KokoEatingBananas {
    //Binary Search on Answer (Optimal) - Time Complexity: O(n * log(m)) - Space Complexity: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high = 0;
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }
        int result =high;

        while(low<=high){
            int k= low+(high-low)/2;
            long hours=0;
            for(int i=0;i<piles.length;i++){
                hours+=(long)(piles[i]+k-1) /k;
            }
            if(hours<=h){
                result=k;
                high=k-1;
            }else{
                low=k+1;
            }
        }
        return result;
    }
}
