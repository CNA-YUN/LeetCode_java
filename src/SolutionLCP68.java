import java.util.HashMap;

public class SolutionLCP68 {
    public int beautifulBouquet(int[] flowers, int cnt) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        int left = 0;
        int sum = 0;
        for (int i = 0; i < flowers.length; i++) {
            counts.put(flowers[i], counts.getOrDefault(flowers[i], 0) + 1);
            while (counts.get(flowers[i]) > cnt) {
                counts.put(flowers[left], counts.get(flowers[left]) - 1);
                left++;
            }
            sum += i - left + 1;
        }
        return sum;
    }
}
