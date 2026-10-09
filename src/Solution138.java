public class Solution138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node p = head;
        while (p != null) {
            Node n = new Node(p.val);
            n.next = p.next;
            p.next = n;
            p = n.next;
        }
        p = head;
        while (p != null) {
            Node later = p.next;
            if (later != null) {
                later.random = p.random == null ? null : p.random.next;
                p = p.next;
            }
            p = p.next;
        }
        Node newHead = new Node(0);

        p = head;
        Node np = newHead;
        while (p != null) {
            np.next = p.next;
            np = np.next;
            p.next = np.next;
            p = p.next;
        }
        return newHead.next;
    }
}
