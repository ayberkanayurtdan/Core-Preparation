public class BalancedBinaryTree {
    // DFS (Recursive) - Time Complexity: O(N) - Space Complexity: O(H)
    public boolean isBalanced(TreeNode root) {
        if(height(root)!=-1) return true;
        return false;
    }

    private int height(TreeNode node){
        if(node==null) return 0;

        int leftH=height(node.left);
        if(leftH==-1) return -1;

        int rightH=height(node.right);
        if(rightH==-1) return -1;

        if(Math.abs(leftH-rightH)>1) return -1;

        return Math.max(leftH,rightH)+1;
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
