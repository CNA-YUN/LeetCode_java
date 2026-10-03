public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        int carry = 0;
        ListNode res = new ListNode(0, null);
        ListNode[] tailarr = new ListNode[1];
        tailarr[0] = res;
        while (c1 != null && c2 != null) {
            ListNode dummy = new ListNode((c1.val + c2.val + carry) % 10, null);
            carry = (c1.val + c2.val + carry) / 10;
            tailarr[0].next = dummy;
            tailarr[0] = dummy;
            c1 = c1.next;
            c2 = c2.next;
        }
        carry = link(c1, carry, tailarr);
        carry = link(c2, carry, tailarr);
        if (carry != 0) {
            ListNode dummy = new ListNode(carry, null);
            tailarr[0].next = dummy;
        }
        return res.next;
    }

    private int link(ListNode c1, int carry, ListNode[] tailarr) {
        while (c1 != null) {
            ListNode dummy = new ListNode((c1.val + carry) % 10, null);
            carry = (c1.val + carry) / 10;
            tailarr[0].next = dummy;
            tailarr[0] = dummy;
            c1 = c1.next;
        }
        return carry;
    }
}
