public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre, cur, nxt, end;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        pre = dummy;
        while (true) {
            end = pre;
            for (int i = 0; i < k; i++) {
                end = end.next;
                if (end == null)
                    return dummy.next;
            }
            ListNode group_tail = pre.next;
            cur = group_tail.next;
            for (int i = 1; i < k; i++) {
                nxt = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = nxt;
            }
            group_tail.next = cur;
            pre = group_tail;
        }
    }
}
