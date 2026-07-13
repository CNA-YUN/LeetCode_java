public class Solution825 {
    public int numFriendRequests(int[] ages) {
        int count = 0;
        int[] cnt= new int[121];
        for (int age : ages) {
            cnt[age]++;
        }
        int y = 1;
        int window = 0;
        for(int x = 1; x <cnt.length; x++){
            window +=cnt[x];
            while(2*y<=x+14){// x不能发给y
                window -=cnt[y];
                y++;
            }
            if(window>0){
                count+=cnt[x]*window-cnt[x];
            }
        }
        return count;
    }
}
