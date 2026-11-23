import java.util.PriorityQueue;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            if (tmp.next != null) {
                pq.add(tmp.next);
            }
            tail.next = tmp;
            tail = tail.next;
        }
        return dummy.next;
    }
}
