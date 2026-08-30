public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode res = new ListNode(Integer.MIN_VALUE, null);
        while (p != null) {
            ListNode tmp = p;
            p = p.next;
            ListNode start = res;
            while (tmp.val >= start.val) {
                if (start.next == null || start.next.val >= tmp.val) {
                    tmp.next = start.next;
                    start.next = tmp;
                    break;
                } else {
                    start = start.next;
                }
            }
        }
        return res.next;
    }
}
