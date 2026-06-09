//import java.util.HashMap;


public class Solution2784 {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] cnt = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            int x = nums[i];
            if(x>n||x==n&&cnt[x]>1||x<n&&cnt[x]==1){
                return false;
            }
            cnt[x]++;
        }
        return true;
    }
}
