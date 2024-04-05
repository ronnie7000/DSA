package LinkedLists;

public class ReverseLinkedList2 {

    private static ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;
        ListNode prev = null, current = head, next = head.next;
        int i = 1;
        while (i < k) {
            current.next = prev;
            prev = current;
            current = next;
            next = next.next;
            i++;
        }
        current.next = prev;
        head.next = next;
        return current;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode p = head;
        if (m == 1) {
            return reverse(head, n - m + 1);
        }
        while (p != null && i + 1 < m) {
            p = p.next;
            i++;
        }
        p.next = reverse(p.next, n - m + 1);
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        ListNode ans = reverseBetween(node, 1, 4);
        while (ans != null) {
            System.out.println(ans.data);
            ans = ans.next;
        }
    }
}
