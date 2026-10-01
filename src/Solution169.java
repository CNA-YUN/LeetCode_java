public class Solution169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int temp = nums[0];
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if (cnt == 0) {
                temp = nums[i];
                cnt++;
                continue;
            }
            if (nums[i] != temp) {
                cnt--;
            } else {
                cnt++;
            }
        }
        return temp;
    }
}
