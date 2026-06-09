public class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        /*
        只考虑最终位置，贪心思维
         */
        int n = moves.length();
        int pos = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                pos++;
            } else if (c == 'L') {
                pos--;
            } else {
                cnt++;
            }
        }
        if (pos > 0) {
            return pos + cnt;
        } else {
            return Math.abs(pos - cnt);
        }
    }
}
