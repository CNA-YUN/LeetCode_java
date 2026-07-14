public class Solution1248 {
    public int numberOfSubarrays(int[] nums, int k) {
        /*
        solve(k): 奇数个数>=k的子数组数目
        solve(k+1): 奇数个数>=k+1的子数组数目
        solve(k)-solve(k+1): 奇数个数=k的子数组数目
        恰好型滑动窗口 转化为 2个 越长越合法滑动窗口 问题
         */
        return solve(nums,k)-solve(nums,k+1);
    }
    public int solve(int[] nums, int k) {
        /*
          计算数组 nums 中 奇数个数 >= k 的子数组数目
         */
        int n = nums.length;
        int ans = 0;
        int left = 0;
        int count = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                count++;
            }
            while (count >= k) {
                if (nums[left] % 2 != 0) {
                    count--;
                }
                left++;
            }
            ans += left;
        }
        return ans;
    }
}
