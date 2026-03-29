import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    // Backtracking and Pruning (Optimal) - Time Complexity: O(N^(T/M)) - Space Complexity: O(T/M)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0,candidates,target,new ArrayList<>(),result);
        return result;
    }

    private void backtrack(int start, int[] candidates,int target, List<Integer> current, List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(target-candidates[i]<0) break;
            current.add(candidates[i]);
            backtrack(i,candidates,target-candidates[i],current,result);
            current.remove(current.size()-1);
        }
    }
}
