import java.util.ArrayList;
import java.util.List;


public class Solution658 {
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int low = 0, high = n - 1;
        while (low > high || high - low + 1 > k) {
            if (Math.abs(x - arr[low]) <= Math.abs(x - arr[high])) {
                high--;
            } else {
                low++;
            }
        }
        for (int i = low; i <= high; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    public List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int left = lowerBound(arr, x);
        int right = lowerBound(arr, x + 1) - 1;
        while (right - left + 1 < k) {
            if (left == 0) {
                right++;
                continue;
            } else if (right == n - 1) {
                left--;
                continue;
            }
            int low = left - 1;
            int high = right + 1;
            if (Math.abs(x - arr[low]) <= Math.abs(x - arr[high])) {
                left--;
            } else {
                right++;
            }
        }
        while (right - left + 1 > k) {
            right--;
        }
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

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
}
