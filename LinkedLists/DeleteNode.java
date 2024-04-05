package LinkedLists;

public class DeleteNode {
    public static ListNode deleteNode(ListNode head, int x) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.data == x)
                break;
            curr = curr.next;
        }
        if (curr == null)
            return head;
        if (curr.next == null && curr.prev == null)
            return null;
        if (curr.prev == null) {
            curr.next.prev = null;
            return curr.next;
        }
        if (curr.next == null) {
            curr.prev.next = null;
            return head;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.prev = null;
        node1.next = null;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        node2.prev = node1;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        node3.prev = node2;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        node4.prev = node3;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.prev = node4;

        ListNode head = deleteNode(node1, 5);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
