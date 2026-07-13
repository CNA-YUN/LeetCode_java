import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<Integer>();
        int x;
        int i;
        for(int d=1;d<=9;d++){
            x=d;
            i=d;
            while(x<=high&&i<=9){
                if(x>=low){
                    list.add(x);
                }
                x = x*10+i+1;
                i++;
            }
        }
        Collections.sort(list);
        return list;
    }
}
