import java.util.Random;

public class Sort {
    private final Random random = new Random();

    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int left, int right) {
        int p = left + random.nextInt(right - left + 1);
        int pivot = nums[p];
        swap(nums, p, left);
        int i = left + 1;
        int j = right;
        while (true) {
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            if (i <= j) {
                swap(nums, i, j);
            } else {
                break;
            }
        }
        swap(nums, left, j);
        return j;
    }

}
