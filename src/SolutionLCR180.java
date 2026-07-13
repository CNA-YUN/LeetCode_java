import java.util.ArrayList;
import java.util.List;

public class SolutionLCR180 {
    public int[][] fileCombination(int target) {
        if(target<3)return new int[0][0];
        List<int[]> result = new ArrayList<>();
        int left = 1;
        int right = 1;
        int sum = left;
        while(right<target){
            if(sum<target){
                right++;
                sum += right;
            }else if (sum>target){
                sum -= left;
                left++;
            }else{
                int[] temp = new int[right-left+1];
                for(int i=0; i<temp.length; i++){
                    temp[i] = left + i;
                }
                result.add(temp);
                right++;
                sum += right;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
