import java.util.Arrays;

public class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int len = arr2.length;
        int cnt = 0;
        for (int j : arr1) {
            int idx = lowerBound(arr2, j - d);
            if (idx == len) {
                cnt++;
            } else if (arr2[idx] > j + d) {
                cnt++;
            }
        }
        return cnt;
    }

    public int lowerBound(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
