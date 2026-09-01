import java.util.Arrays;

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if (n == 0) return null;

        int leftsize = findIndexOfNode(inorder, postorder[n - 1]);
        int[] inleft = Arrays.copyOfRange(inorder, 0, leftsize);
        int[] inright = Arrays.copyOfRange(inorder, leftsize + 1, n);
        int[] postleft = Arrays.copyOfRange(postorder, 0, leftsize);
        int[] postright = Arrays.copyOfRange(postorder, leftsize, n - 1);
        TreeNode left = buildTree(inleft, postleft);
        TreeNode right = buildTree(inright, postright);
        return new TreeNode(postorder[n - 1], left, right);
    }

    private int findIndexOfNode(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) return i;
        }
        return -1;
    }
}
