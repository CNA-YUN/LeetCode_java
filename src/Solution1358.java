public class Solution1358 {
    public int numberOfSubstrings(String s) {
        int[] judge =new int[3];
        int left=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            judge[s.charAt(i)-'a']++;
            while(judge[0]>0 && judge[1]>0 && judge[2]>0) {
                judge[s.charAt(left)-'a']--;
                left++;
            }
            count+=left;
        }
        return count;

    }
}
