public class Solution2529 {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int positive = 0, negative = 0;
        positive = findlargestBound(nums, 0);
        negative = findlargestBound(nums, -1);

        return Math.max(n - positive, negative);


    }

    public int findlargestBound(int[] nums, int target) {
        /*
        大于 target 的 最小值 的 下标
        范围[0,len]
         */

        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
