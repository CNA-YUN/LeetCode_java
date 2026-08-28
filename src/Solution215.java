import java.util.Random;

public class Solution215 {
    private final Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int targetid = n - k;
        int left = 0, right = n - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == targetid) {
                return nums[index];
            } else if (index < targetid) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int p = left + random.nextInt(right - left + 1);
        swap(nums, p, left);
        int pivot = nums[left];
        int i = left;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            } else {
                break;
            }
        }
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
