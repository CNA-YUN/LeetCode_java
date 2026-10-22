import java.util.ArrayList;
import java.util.List;

public class Solution114 {
    List<TreeNode> list;

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        list = new ArrayList<>();
        preOrder(root);
        int len = list.size();
        for (int i = 0; i < len; i++) {
            TreeNode temp = list.get(i);
            temp.left = null;
            temp.right = i == len - 1 ? null : list.get(i + 1);
        }
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
