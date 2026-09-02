public class Solution481 {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int res = 0;
        int i = 2;
        char flag = '1';
        while (sb.length() < n) {
            if (flag == '1') {
                sb.append(String.valueOf(flag).repeat(Math.max(0, sb.charAt(i) - '0')));
                flag = '2';
            } else {
                sb.append(String.valueOf(flag).repeat(Math.max(0, sb.charAt(i) - '0')));
                flag = '1';
            }
            i++;
        }
        for (char c : sb.substring(0, n).toCharArray()) {
            if (c == '1') {
                res++;
            }
        }
        return res;
    }
}
