class Solution2904 {
    int cnt = 0;
    int left = 0;
    StringBuilder sb = new StringBuilder();

    public String shortestBeautifulSubstring(String s, int k) {
        int len = s.length()+1;
        sb.append(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
            if (cnt == k) {
                while (s.charAt(left) != '1') {
                    left++;
                }
                len = getLen(s, len, left, i);
            } else if (cnt > k) {
                do {
                    if (s.charAt(left) == '1') {
                        cnt--;
                    }
                    left++;
                } while (cnt > k || s.charAt(left) != '1');
                len = getLen(s, len, left, i);
            }
        }
        if(sb.toString().equals(s)&&len==s.length()+1){
            return "";
        }
        return sb.toString();
    }

    private int getLen(String s, int len, int left, int i) {
        if (len > i - left + 1) {
            len = i - left + 1;
            sb.delete(0, sb.length());
            sb.append(s, left, i + 1);
        } else if (len == i - left + 1) {
            if (sb.toString().compareTo(s.substring(left, i + 1)) >=0) {
                sb.delete(0, sb.length());
                sb.append(s, left, i + 1);
            }
        }
        return len;
    }
}