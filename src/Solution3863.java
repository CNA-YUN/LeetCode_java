public class Solution3863 {
    public int minOperations(String s) {
        int n = s.length();
        boolean issorted = true;
        char mn = Character.MAX_VALUE;
        char mx = Character.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && s.charAt(i) > s.charAt(i + 1)) {
                issorted = false;
            }
            mn = (char) Math.min(mn, s.charAt(i));
            mx = (char) Math.max(mx, s.charAt(i));
        }
        if (issorted) {
            return 0;
        }
        if (n == 2) {
            return -1;
        }
        if (s.charAt(0) == mn || s.charAt(n - 1) == mx) {
            return 1;
        }
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == mn || s.charAt(i) == mx)
                return 2;

        }
        return 3;

    }
}
