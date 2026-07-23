public class Solution1287 {
    private int lowerBound(int[] nums, int target) {
        /*
          return: nums 数组中 >= target 的元素的最小下标
         */
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int findSpecialInteger(int[] arr) {
        int m = arr.length / 4;
        for (int i : new int[]{m, 2 * m + 1}) {
            int p = lowerBound(arr, arr[i]);
            if (arr[p + m] == arr[i]) {
                return arr[i];
            }
        }
        return arr[3 * m + 2];
    }
}
