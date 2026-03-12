public class LowestCommonAncestorOfBinarySearchTree {
    // Iterative Search(Optimal) - Time Complexity: O(H) - Space Complexity: O(1)
    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current=root;

        while(current!=null){
            if(p.val<current.val && q.val<current.val){
                current=current.left;
            }else if(p.val>current.val && q.val>current.val){
                current=current.right;
            }else{
                break;
            }
        }

        return current;
    }
    // DFS (Recursive) - Time Complexity: O(H) - Space Complexity: O(H)
    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val==root.val || q.val==root.val) return root;
        if(p.val<root.val&&q.val<root.val) root=lowestCommonAncestorRecursive(root.left,p,q);
        if(p.val>root.val&&q.val>root.val) root=lowestCommonAncestorRecursive(root.right,p,q);

        return root;
    }

    
    @SuppressWarnings("unused")
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
  }
}
