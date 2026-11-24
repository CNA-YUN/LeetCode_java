public class Solution3411 {
    public int maxLength(int[] nums) {
        /**
         * 遍历左右端点获得子数组
         */
        int n = nums.length;
        int ans = 1;
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                /**
                 * 子数组范围为[left,right]
                 */
                int tmp_gcd = nums[left];
                int tmp_lcm = nums[left];
                int mul = 1;
                for (int i = left; i <= right; i++) {
                    tmp_gcd = gcd(tmp_gcd, nums[i]);
                    tmp_lcm = lcm(tmp_lcm, nums[i]);
                    mul *= nums[i];
                }
                if (mul == tmp_gcd * tmp_lcm) {
                    ans = Math.max(ans, right - left + 1);
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        /**
         * 求最大公约数用欧几里得算法
         */
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    private int lcm(int a, int b) {
        /**
         * 求最小公倍数
         * 
         */

        return a * b / gcd(a, b);
    }
}
