public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        s -= Math.abs(target);
        if (s < 0 || s % 2 != 0)
            return 0;
        int m = nums.length;
        int n = s / 2;
        int[][] memo = new int[m][n + 1];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c <= n; c++) {
                memo[r][c] = -1;
            }
        }
        return dfs(m - 1, n, nums, memo);
    }

    private int dfs(int i, int weight, int[] nums, int[][] memo) {
        if (i < 0) {
            return weight == 0 ? 1 : 0;
        }
        if (memo[i][weight] != -1)
            return memo[i][weight];
        int res = dfs(i - 1, weight, nums, memo);
        if (weight >= nums[i]) {
            res += dfs(i - 1, weight - nums[i], nums, memo);
        }
        memo[i][weight] = res;
        return res;
    }
}
