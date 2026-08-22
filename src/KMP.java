public class KMP {
    public int strMatch(String s, String p) {
        if (s.isEmpty() || p.isEmpty() || s.length() < p.length()) return -1;
        // 构造 next[]
        int[] next = new int[p.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                next[i] = j + 1;
                j++;
            } else {
                next[i] = 0;
            }
        }
        // 开始扫描主串
        for (int i = 0, j = 0; i < s.length(); ) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
                i++;
                if (j == p.length()) return i - p.length();
                continue;
            }
            if (j == 0) {
                i++;
            } else {
                j = next[j - 1];
            }
        }
        return -1;
    }
}
