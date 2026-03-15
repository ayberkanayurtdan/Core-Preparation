import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int preOrderIndex=0;
    // Divide and Conquer with HashMap (Optimal) - Time Complexity: O(n) - Space Complexity: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        return buildSubtree(preorder,0,preorder.length-1,inorderMap);
    }

    private TreeNode buildSubtree(int[] preorder, int left, int right, Map<Integer,Integer> inorderMap){
        if(left>right) return null;

        int rootValue=preorder[preOrderIndex++];
        TreeNode root=new TreeNode(rootValue);

        int mid=inorderMap.get(rootValue);
        root.left=buildSubtree(preorder,left,mid-1,inorderMap);

        root.right=buildSubtree(preorder,mid+1,right,inorderMap);

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
