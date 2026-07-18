import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution2080 {
    int[] arr;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public Solution2080(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        /*
        哈希表 map 记录 arr 数组中同一元素的下标集合
        eg: map[4]={2},map[33]={1,7}
         */
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) {
            return 0;
        }
        /*
        二分查找
        1.map[value]数组中 >=left 的最小元素小标
        2.map[value]数组中 <=right 的最大元素小标
         */
        Integer[] nums = new Integer[map.get(value).size()];
        map.get(value).toArray(nums);
        int start = lowerBound(nums, left);
        int end = lowerBound(nums, right + 1) - 1;
        if (start >= map.get(value).size() || end < 0 || end < start) {
            return 0;
        } else {
            return end - start + 1;
        }
    }

    private int lowerBound(Integer[] nums, int target) {
        /*
          return: nums 数组中 >= target 的元素的最小下标
         */
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
/*
  Your Solution2080 object will be instantiated and called as such:
  Solution2080 obj = new Solution2080(arr);
  int param_1 = obj.query(left,right,value);
 */
