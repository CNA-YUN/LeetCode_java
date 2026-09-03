public class Solution424 {
    public int characterReplacement(String s, int k) {
        int sum = 0;
        int mx = 0;
        int res = Integer.MIN_VALUE;
        int n = s.length();
        int[] map = new int[26];
        int left = 0;
        for (int i = 0; i < n; i++) {
            sum++;
            mx = Math.max(mx, ++map[s.charAt(i) - 'A']);
            while (sum - mx > k) {
                sum--;
                mx = Math.max(mx, --map[s.charAt(left) - 'A']);
                left++;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
