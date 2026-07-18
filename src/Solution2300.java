import java.util.Arrays;

public class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            pairs[i] = lowerBound(potions,spells[i],success);
        }
        return pairs;
    }
    private int lowerBound(int[] potions, int target,long success) {
        int n = potions.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) /2;
            if((long) potions[mid] *target<success) {
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return n-low;
    }
}
