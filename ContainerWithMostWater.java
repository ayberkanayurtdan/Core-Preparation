public class ContainerWithMostWater {
    //Two Pointers (Optimal) - Time Complexity= O(n) - Space Complexity= O(1)
    public int maxArea(int[] height){
        int l=0;
        int r= height.length-1;
        int max=0;

        while(l<r){
            int area=(r-l)*(Math.min(height[l],height[r]));
            if(area>max){
                max=area;
            }
            if(height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }
}
