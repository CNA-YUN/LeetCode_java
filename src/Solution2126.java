import java.util.Arrays;

public class Solution2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        int n = asteroids.length;
        long curmass = mass;

        for (int i = 0; i < n; i++) {
            if (curmass < asteroids[i]) {
                return false;
            } else {
                curmass += asteroids[i];
            }
        }
        return true;
    }
}
