import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorderTraversal {
    // Divide and Conquer with Postorder Priority (Optimal) - Time Complexity: O(n) - Space Complexity: O(n)
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex=postorder.length-1;
        Map<Integer,Integer> inorderMap=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);            
        }
        return buildSubtree(postorder,0,inorder.length-1,inorderMap);
    }
    
    private TreeNode buildSubtree(int[] postorder, int left,int right, Map<Integer,Integer> inorderMap){
        if(left>right) return null;

        int rootValue=postorder[postOrderIndex--];
        TreeNode root= new TreeNode(rootValue);

        int mid=inorderMap.get(rootValue);

        root.right=buildSubtree(postorder,mid+1,right,inorderMap);
        root.left=buildSubtree(postorder,left,mid-1,inorderMap);
        
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
