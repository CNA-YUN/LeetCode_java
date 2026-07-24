public class Solution1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int mx = 0;
        for (int i : nums) {
            mx = Math.max(mx, i);
        }
        int mn = 1;
        return lowerBound(mn, mx, threshold, nums);
    }

    private int lowerBound(int low, int high, int threshold, int[] nums) {
        int left = low;
        int right = high;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private int check(int[] nums, int mid) {
        int cnt = 0;
        for (int num : nums) {
            cnt += (num + mid - 1) / mid;
        }
        return cnt;
    }
}
