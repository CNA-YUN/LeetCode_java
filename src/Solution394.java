public class Solution394 {
    int i;

    public String decodeString(String s) {
        i = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder res = new StringBuilder();
        int k = 0;
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                k = k * 10 + c - '0';
            } else if (Character.isAlphabetic(c)) {
                res.append(c);
            } else if (c == '[') {
                String tstr = decode(s);
                res.repeat(tstr, k);
                k = 0;
            } else {
                break;
            }
        }
        return res.toString();
    }
}
