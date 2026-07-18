import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution3488 {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        List<Integer> answer = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> list : map.values()) {
            // 首尾添加哨兵
            int head = list.get(0), tail = list.get(list.size() - 1);
            list.add(n + head);
            list.add(0, tail - n);
        }
        for (int q : queries) {
            List<Integer> list = map.get(nums[q]);
            if (list.size() <= 3) {
                answer.add(-1);
            } else {
                int pos = binarySearch(list, q);
                if (pos < 0) {
                    answer.add(-1);
                } else {
                    answer.add(Math.min(list.get(pos) - list.get(pos - 1), list.get(pos + 1) - list.get(pos)));
                }
            }
        }
        return answer;
    }

    private int binarySearch(List<Integer> list, int value) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == value) {
                return mid;
            } else if (list.get(mid) > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
