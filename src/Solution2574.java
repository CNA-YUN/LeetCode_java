public class Solution2574 {
    public int[] leftRightDifference(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        int leftsum = 0;
        for(int i=0; i<n; i++){
            res[i]=leftsum;
            leftsum+=nums[i];
        }
        int rightsum = 0;
        for(int i=n-1; i>=0; i--){
            res[i]=Math.abs(rightsum-res[i]);
            rightsum+=nums[i];
        }
        return res;
    }
}
