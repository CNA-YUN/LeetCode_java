//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) {
        SolutionLCP08 solution = new SolutionLCP08();
        int[][] increase = {{2,8,4},{2,5,0},{10,9,8}};
        int[][] requirements = {{2,11,3},{15,10,7},{9,17,12},{8,1,14}};
        int[] res =  solution.getTriggerTime(increase, requirements);
        System.out.println(Arrays.toString(res));
    }
}