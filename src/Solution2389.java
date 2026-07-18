import java.util.Arrays;

public class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int[] answer = new int[queries.length];
        int n = nums.length;
        int m = queries.length;
        Arrays.sort(nums);
        int[] sum = new int[n];
        /*
        sum[i]: nums[0]+nums[1]+...+nums[i]
        */
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            int target = queries[i];
            // 二分查找: 找到数组 sum 中 大于 target 的元素的最小下标
            while (left <= right) {
                int mid = (left + right) / 2;
                if (sum[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // left的取值范围:[0..n];left 即为 前缀和<=target 的子数组的最大长度
            answer[i] = left;
        }
        return answer;

    }
}
