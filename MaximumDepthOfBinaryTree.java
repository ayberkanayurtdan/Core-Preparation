import java.util.LinkedList;
import java.util.Queue;


public class MaximumDepthOfBinaryTree {
    //DFS (Recursive) - Time Complexity: O(N) - SpaceComplexity:O(H)
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
    }

    //BFS (Iterative) - Time Complexity: O(N) - SpaceComplexity:O(W)
    public int maxDepthWithQueue(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode current=queue.poll();
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);  
            }
            depth++;
        }
        return depth;
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
