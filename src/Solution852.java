public class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                left = mid + 1;
            } else if (mid == n - 1) {
                right = mid - 1;
            } else {
                if (arr[mid] < arr[mid + 1]) {
                    left = mid + 1;
                } else if (arr[mid] < arr[mid - 1]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return left;
    }
}
