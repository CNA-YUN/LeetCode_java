import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < mindiff) {
                mindiff = arr[i + 1] - arr[i];
                res.clear();
                res.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            } else if (arr[i + 1] - arr[i] == mindiff) {
                res.add(new ArrayList<>(Arrays.asList(arr[i], arr[i + 1])));
            }
        }
        return res;
    }
}
