/**
 * Solution3644
 */
public class Solution3644 {
    public int sortPermutation(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }
        return ans == -1 ? 0 : ans;
    }
}