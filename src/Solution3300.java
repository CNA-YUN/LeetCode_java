class Solution3300 {
    public int minElement(int[] nums) {
        int n = nums.length;
        int res = (int) 10e4;

        for (int i = 0; i < n; i++) {
            res = Math.min(countSum(nums[i]), res);
        }
        return res;
    }

    public int countSum(int x) {
        int num = x;
        int res = 0;

        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}