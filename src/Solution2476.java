
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

public class Solution2476 {
    List<Integer> nums = new ArrayList<>();

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int n = queries.size();
        inOrder(root);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int target = queries.get(i);
            int start = higherBound(nums, target);
            int end = lowerBound(nums, target);
            res.get(i).add(start);
            res.get(i).add(end);
        }
        return res;
    }

    private int lowerBound(List<Integer> nums, int target) {
        /*
          return: nums 数组中 >= target 的元素的最小下标
         */
        int n = nums.size();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left == n ? -1 : nums.get(left);
    }

    private int higherBound(List<Integer> nums, int target) {
        /*
          return: nums 数组中 <= target 的元素的最大下标
         */
        int n = nums.size();
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right == -1 ? -1 : nums.get(right);
    }

    private void inOrder(TreeNode root) {
        /*
         中序遍历
        */
        if (root == null) {
            return;
        }
        inOrder(root.left);
        nums.add(root.val);
        inOrder(root.right);
    }
}
