public class Solution1979 {
    public int findGCD(int[] nums) {
        int mn = nums[0], mx = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mn = Math.min(nums[i], mn);
            mx = Math.max(nums[i], mx);
        }
        return searchGCD(mn, mx);
    }

    public int searchGCD(int m, int n) {
        /*
        求 m 和 n 的最大公约数
         */
        if (m < n) {
            int temp = n;
            n = m;
            m = temp;
        }
        while (n != 0) {
            int temp = n;
            n = m % n;
            m = temp;
        }
        return m;
    }
}
