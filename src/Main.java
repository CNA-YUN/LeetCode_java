//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Solution3488 solution = new Solution3488();
        int[] nums = {1,3,1,4,1,3,2}, queries = {0,3,5};
        List<Integer> list = solution.solveQueries(nums, queries);
        System.out.println(list);
    }
}