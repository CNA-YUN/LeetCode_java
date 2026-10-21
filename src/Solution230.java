import java.util.*;

public class Solution230 {
    private List<Integer> list;

    public int kthSmallest(TreeNode root, int k) {
        list = new ArrayList<>();
        inOrder(root);

        return list.get(k - 1);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }
}
