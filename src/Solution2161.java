public class Solution2161 {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int minpivot = 0, maxpivot = 0, equalpivot = 0;

        for (int num : nums) {
            if (num == pivot) {
                equalpivot++;
            } else if (num > pivot) {
                maxpivot++;
            } else {
                minpivot++;
            }
        }
        int left = 0, mid = minpivot, right = minpivot + equalpivot;
        for (int num : nums) {
            if (num == pivot) {
                res[mid++] = num;
            } else if (num > pivot) {
                res[right++] = num;
            } else {
                res[left++] = num;
            }
        }

        return res;
    }
}
