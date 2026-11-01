public class Solution453 {
    public int minMoves(int[] nums) {
        int mn = Integer.MAX_VALUE;
        for (int x : nums) {
            mn = Math.min(x, mn);
        }
        int res = 0;
        for (int x : nums) {
            res += Math.abs(x - mn);
        }
        return res;
    }
}
