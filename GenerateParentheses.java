import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {
    //Stack (Optimal) - Time Complexity: O(4^n / sqrt(n)) - Space Complexity: O(n)
    public List<String> generateParenthesis(int n) {
        List<String> result= new ArrayList<>();
        Stack<Object[]> stack=new Stack<>();
        stack.push(new Object[]{"",0,0});
        while(!stack.isEmpty()){
            Object[] obj=stack.pop();
            String s=(String) obj[0];
            int open=(int) obj[1];
            int close=(int) obj[2];
            if(s.length()==2*n){
                result.add(s);
                continue;
            }
            if(close<open){
                stack.push(new Object[]{s+")",open,close+1});
            }
            if(open<n){
                stack.push(new Object[]{s+"(",open+1,close});
            }
        }
        return result;
    }
}