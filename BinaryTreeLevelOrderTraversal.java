import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    // BFS Approach with Queue (Optimal) - Time Complexity: O(n) - Space Complexity: O(w)
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        
        Queue<TreeNode> queue= new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            int size= queue.size();
            if (result.size() <= level) {
                result.add(new ArrayList<>());
            }
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
                result.get(level).add(curr.val);
            }
            level++;
        }
        return result;
    }


    @SuppressWarnings("unused")
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
