import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum;
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                sum = nums[i] + nums[start] + nums[end];
                res = Math.abs(sum - target) < Math.abs(res - target) ? sum : res;
                if (sum == target) {
                    return target;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return res;
    }
}
