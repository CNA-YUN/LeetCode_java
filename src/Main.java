//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        Solution628 solution = new Solution628();
        int[] weights = new int[]{-1,-2,-3};
        int n = 1000000000;
        System.out.println(solution.maximumProduct(weights));


//        System.out.println(solution.closestNodes(root,queries));
    }
}