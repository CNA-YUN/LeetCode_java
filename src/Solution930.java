public class Solution930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int left1 = 0, left2 = 0, sum1 = 0, sum2 = 0;
        int count = 0;
        for (int i=0;i<n;i++) {
            sum1 += nums[i];
            while (sum1 >= goal&& left1 <=i) {
                sum1 -= nums[left1++];
            }
            count+=left1;
            sum2 += nums[i];
            while (sum2 > goal&& left2 <=i) {
                sum2 -= nums[left2++];
            }
            count-=left2;
        }
        return count;
    }
}
