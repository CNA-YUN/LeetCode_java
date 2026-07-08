import java.util.ArrayList;
import java.util.List;

public class Solution3754 {
    public long sumAndMultiply(int n) {
        List<Integer> nums = new ArrayList<>();
        int num = n;
        int cnt = 0;
        while (num > 0) {
            cnt++;
            nums.add(num%10);
            num /= 10;
        }
        long sum = 0;
        long x=0;
        for(int i=nums.size()-1;i>=0;i--) {
            if(nums.get(i) == 0) continue;
            sum+=nums.get(i);
            x = x * 10 + nums.get(i);
        }
        return (long)sum*x;
    }
}
