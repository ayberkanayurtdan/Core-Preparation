import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    // DFS (Recursive) - Time Complexity: O(N) - Space Complexity: O(H)
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        invertTree(root.right);
        invertTree(root.left);
    
        TreeNode temp=root.right;
        root.right=root.left;
        root.left=temp;
        return root;
    }

    public TreeNode invertTreeWithQueue(TreeNode root) {
        // BFS (Iterative) - Time Complexity: O(N) - Space Complexity: O(W)
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode current=queue.poll();
                TreeNode temp= current.right;
                current.right=current.left;
                current.left=temp;
                if(current.left!=null) queue.offer(current.left);
                if(current.right!=null) queue.offer(current.right);
            }
        }
        return root;
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
