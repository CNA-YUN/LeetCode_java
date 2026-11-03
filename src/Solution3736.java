public class Solution3736 {
    public int minMoves(int[] nums) {
        int mx = Integer.MIN_VALUE;
        for (int x : nums) {
            mx = Math.max(x, mx);
        }
        int ans = 0;
        for (int x : nums) {
            ans += Math.abs(mx - x);
        }
        return ans;
    }
}
