import java.util.Stack;

public class LargestRectangleInHistogram {
    // Monotonic Stack (Optimal) - Time Complexity: O(n) - Space Complexity: O(n)
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=heights.length;i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int height= heights[stack.pop()];
                int weight;
                if (stack.isEmpty()) {
                    weight = i; 
                } else {
                    weight = i - stack.peek() - 1;
                }               
                int area=weight*height;
                maxArea=Math.max(area,maxArea);
            }
            if(i<heights.length) stack.push(i);
        }
        return maxArea;
    }
    // Brute Force (Nested Loops) - Time Complexity: O(n^2) - Space Complexity: O(1)
    public int largestRectangleAreaBruteForce(int[] heights) {
        
        int maxArea=0;
        for(int i=0;i<heights.length;i++){
            int left=i;
            int right=i;

            while(left>0 && heights[i]<=heights[left-1]){
                left--;
            }
            while(right<heights.length-1 && heights[i]<=heights[right+1]){
                right++;
            }
            int area=heights[i]*(right-left+1);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}
