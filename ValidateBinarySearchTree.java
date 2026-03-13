public class ValidateBinarySearchTree {
    // DFS Approach with Range Constraints (Optimal) - Time Complexity: O(n) - Space Complexity: O(h)
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return checkValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean checkValid(TreeNode node, long min, long max){
        if(node==null) return true;
        if(node.val<=min || node.val>=max) return false;

        return checkValid(node.right,(long)node.val,max)&&checkValid(node.left,min,(long)node.val);
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
