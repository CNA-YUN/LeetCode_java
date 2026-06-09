import java.util.ArrayList;
import java.util.List;

public class Solution2553 {
    public int[] separateDigits(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            while (x > 0) {
                list.add(x % 10);
                x /= 10;
            }
        }
        int m = list.size();
        int[] res = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            res[i] = list.get(m - 1 - i);
        }
        return res;
    }


}
