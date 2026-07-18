//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

import java.util.Arrays;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Solution1170 solution = new Solution1170();
//        int[] nums = new int[]{0,0};
//        int res=solution.maximumCount(nums);
        String[] queries = {"bbb","cc"}, words = {"a","aa","aaa","aaaa"};
        System.out.println(Arrays.toString(solution.numSmallerByFrequency(queries, words)));
    }
}