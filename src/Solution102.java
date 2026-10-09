import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution102 {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    list.add(node.val);
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }

            }
            res.add(list);
        }
        return res;
    }
}
