public class TrappingRainWater {
    // Two Pointers (Optimal) - Time Complexity= O(n) - Space Complexity= O(1)
    public int trap(int[] height) {
        if(height==null || height.length<3) return 0;
        int l=0, r=height.length-1, maxL=0,maxR=0,sum=0;
        while(l<r){
            if(height[l]<height[r]){
                if(height[l]>=maxL){
                    maxL=height[l];
                }else{
                    sum+=(maxL-height[l]);
                }
                l++;
            }else{
                if(height[r]>=maxR){
                    maxR=height[r];
                }else{
                    sum+=(maxR-height[r]);
                }
                r--;
            } 
        }
        return sum;
    }
    // Brute Force Scanning - Time Complexity= O(n^2) - Space Complexity= O(1)
    public int trapBruteForce(int[] height) {
        if(height.length<3 || height==null) return 0;
        int sum=0;
        for(int i=1;i<height.length;i++){
            int l=i-1, r=i+1,maxL=0,maxR=0;
            while(l>=0){
                if(height[l]>maxL) maxL=height[l];
                l--;
            }
            while(r<height.length){
                if(height[r]>maxR) maxR=height[r];
                r++;
            }
            int area= Math.min(maxL,maxR)-height[i];
            if(area<0) continue;
            sum+=area;
        }
        return sum;
    }
}
