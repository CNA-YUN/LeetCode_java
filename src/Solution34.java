public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int start = lowerBound(nums, target);
        int end = lowerBound(nums, target + 1);
        if (start>n-1||nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, end-1};
    }

    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {   // [left,mid] < target
                left = mid + 1;
            } else {    // [mid,right] >= target
                right = mid - 1;
            }
        }

        return left;

    }
}
