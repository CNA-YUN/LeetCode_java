import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution3536 {
    public int maxProduct(int n) {
        int mx1 = 0, mx2 = 0;
        int x = n;
        while (x > 0) {
            int d = x % 10;
            if (d > mx1) {
                mx2 = mx1;
                mx1 = d;
            } else if (d > mx2) {
                mx2 = d;
            }
            x /= 10;
        }
        return mx1 * mx2;
    }

}
