public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nums[n / 2]);
        root.left = dfs(nums, 0, n / 2 - 1);
        root.right = dfs(nums, n / 2 + 1, n - 1);
        return root;
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode head = new TreeNode(nums[mid]);
        head.left = dfs(nums, start, mid - 1);
        head.right = dfs(nums, mid + 1, end);
        return head;
    }
}
