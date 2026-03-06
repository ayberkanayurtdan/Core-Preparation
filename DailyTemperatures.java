import java.util.Stack;

public class DailyTemperatures {
    //Monotonic Stack (Optimal) - Time Complexity: O(n) - Space Complexity: O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result= new int[temperatures.length];
        Stack<Integer> indexes= new Stack<>();

        for(int i=0; i<temperatures.length;i++){
            while(!indexes.isEmpty() && temperatures[i]>temperatures[indexes.peek()]){
                int num=indexes.pop();
                int diff=i-num;
                result[num]=diff;
            }
            indexes.push(i);
        }
        return result;
    }
    //Brute Force (Nested Loops) - Time Complexity: O(n^2) - Space Complexity: O(1)
    public int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            int j = i + 1; 
            while (j < temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    break;
                }
                j++;
            }
        }
        return result;
    }
}
