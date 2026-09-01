public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int i = findMin(nums);
        if (target > nums[n - 1]) {
            return binarySearch(nums, target, 0, i - 1);
        } else {
            return binarySearch(nums, target, i, n - 1);
        }
    }

    private int findMin(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[n - 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;

            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
