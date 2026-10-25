import java.util.HashMap;
import java.util.Map;

public class Solution437 {
    long sum = 0;
    int ans = 0;
    Map<Long, Integer> cnt = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        sum = 0;
        ans = 0;
        cnt.clear();
        cnt.put(0L, 1);
        preOrder(root, targetSum);
        return ans;
    }

    private void preOrder(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        sum += root.val;
        ans += cnt.getOrDefault(sum - targetSum, 0);
        cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
        preOrder(root.left, targetSum);
        preOrder(root.right, targetSum);
        cnt.put(sum, cnt.get(sum) - 1);
        sum -= root.val;
    }
}
