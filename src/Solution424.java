public class Solution424 {
    public int characterReplacement(String s, int k) {
        int mx = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        int n = s.length();
        int[] map = new int[26];
        int left = 0;
        for (int i = 0; i < n; i++) {
            mx = Math.max(mx, ++map[s.charAt(i) - 'A']);
            while (i - left + 1 - mx > k) {
                mx = Math.max(mx, --map[s.charAt(left) - 'A']);
                left++;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
