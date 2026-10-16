import java.util.Arrays;

public class Solution2262 {
    public long appealSum(String s) {
        int[] last = new int[26];
        Arrays.fill(last, -1);
        long res = 0;
        long temp = 0;
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            temp += i - last[c[i] - 'a'];
            res += temp;
            last[c[i] - 'a'] = i;
        }
        return res;
    }
}
