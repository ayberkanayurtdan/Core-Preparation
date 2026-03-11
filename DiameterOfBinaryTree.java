public class DiameterOfBinaryTree {
    // DFS (Recursive) - Time Complexity: O(N) - Space Complexity: O(H)
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private int height(TreeNode node){
        if(node==null) return 0;
        int leftH=height(node.left);
        int rightH=height(node.right);

        maxDiameter = Math.max(maxDiameter, leftH + rightH);

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
