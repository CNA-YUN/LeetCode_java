import java.util.Arrays;

public class Solution462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int midx = nums[n / 2];
        int ans = 0;
        for (int x : nums) {
            ans += Math.abs(midx - x);
        }
        return ans;
    }
}
