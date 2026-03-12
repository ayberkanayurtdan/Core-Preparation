import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    // BFS Approach (Optimal) - Time Complexity: O(n) - Space Complexity: O(w)
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                if(i==size-1) result.add(curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
        }
        return result;
    }
    // DFS Approach (Implicit Stack) - Time Complexity: O(n) - Space Complexity: O(h)
    @SuppressWarnings("unused")
    private class BinaryTreeRightSideViewDfs{
        List<Integer> result=new ArrayList<>();

        public List<Integer> rightSideViewDfs(TreeNode root) {
            dfs(root,0);
            return result;
        }
        public void dfs(TreeNode node, int level){
            if(node==null) return;
            if(result.size()==level) result.add(node.val);
            dfs(node.right,level+1);
            dfs(node.left,level+1);
        }
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
    
