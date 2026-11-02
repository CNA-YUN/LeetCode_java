import java.util.HashMap;
import java.util.Map;

public class Solution13 {
    public int romanToInt(String s) {
        char[] carr=s.toCharArray();
        int n=carr.length;
        Map<Character,Integer> map=new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans=0;
        for(int i=n-1;i>=0;i--){
            int tmp=map.get(carr[i]);
            if (i==n-1) {
                ans+=tmp;
                continue;
            }
            int pre=map.get(carr[i+1]);
            if (tmp<pre) {
                ans-=tmp;
            }else{
                ans+=tmp;
            }
        }
        return ans;
    }
}
