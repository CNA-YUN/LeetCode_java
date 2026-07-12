import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static java.util.Arrays.sort;

public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        HashSet<Integer>set = new HashSet<>();
        for(int num : arr){
            set.add(num);
        }
        Integer[] nums= set.toArray(new Integer[0]);
        Arrays.sort(nums);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i = 0; i < n; i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
