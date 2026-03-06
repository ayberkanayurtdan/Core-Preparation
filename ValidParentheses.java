import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    //Stack (Optimal) - Time Complexity: O(n) - Space Complexity: O(n)
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)){
                if(stack.isEmpty() || stack.pop()!=map.get(ch)) return false;
            }else{
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
