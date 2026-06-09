import java.util.Objects;

public class Solution796 {
    public boolean rotateString(String s, String goal) {
        if(s.equals(goal)){
            return true;
        }
        if (s.length() != goal.length()) {
            return false;
        }
        int n = s.length();

        for (int i = 0; i < n-1; i++) {
            String suba = s.substring(0, i + 1);
            String subb = s.substring(i+1, n);
            if(goal.equals(subb.concat(suba))){
                return true;
            }
        }
        return false;
    }
}
