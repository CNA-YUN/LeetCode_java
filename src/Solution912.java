

public class Solution912 {
    

    public int[] sortArray(int[] nums) {
        Sort sort = new Sort();
        int n = nums.length;
        sort.quickSort(nums, 0, n - 1);
        return nums;
    }
}
