public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = new ListNode(0, head);
        ListNode pre = res;
        while (pre.next != null && pre.next.next != null) {
            ListNode prior = pre.next, later = prior.next;
            pre.next = later;
            prior.next = later.next;
            later.next = prior;
            pre = prior;
        }
        return res.next;
    }
}
