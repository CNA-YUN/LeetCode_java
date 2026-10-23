import java.util.HashMap;
import java.util.Map;

public class Solution105 {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode dfs(int[] pre, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(pre[ps]);
        int mid = indexMap.get(pre[ps]);
        root.left = dfs(pre, ps + 1, ps + mid - is, in, is, mid - 1);
        root.right = dfs(pre, ps + mid - is + 1, pe, in, mid + 1, ie);
        return root;
    }
}
