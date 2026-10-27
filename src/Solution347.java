import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> cnt=new HashMap<>();
        for(int x:nums){
            cnt.put(x,cnt.getOrDefault(x,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer>e:cnt.entrySet()){
            pq.offer(e);
            if (pq.size()>k) {
                pq.poll();
            }
        }
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=pq.poll().getKey();
        }
        return res;
    }
}