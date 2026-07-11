public class Solution2962 {
    public long countSubarrays(int[] nums, int k) {
        long count = 0;
        int[] map = new int[1000001];
        int mx = 0;
        for (int x : nums) {
            mx = Math.max(mx, x);
        }
        int left = 0;
        for (int num : nums) {
            map[num]++;

            while (map[mx] >= k) {
                map[nums[left]]--;
                left++;
            }
            count += left;

        }
        return count;
    }
}
