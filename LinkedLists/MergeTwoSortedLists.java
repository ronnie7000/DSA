package LinkedLists;

public class MergeTwoSortedLists {

    public static ListNode solve(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null)
            return nodeB;
        if (nodeB == null)
            return nodeA;
        ListNode head = null;
        if (nodeA.data < nodeB.data) {
            head = nodeA;
            nodeA = nodeA.next;
        } else {
            head = nodeB;
            nodeB = nodeB.next;
        }
        ListNode temp = head;
        while (nodeA != null && nodeB != null) {
            if (nodeA.data < nodeB.data) {
                temp.next = nodeA;
                nodeA = nodeA.next;
            } else {
                temp.next = nodeB;
                nodeB = nodeB.next;
            }
            temp = temp.next;
        }
        if (nodeA == null) {
            temp.next = nodeB;
        }
        if (nodeB == null) {
            temp.next = nodeA;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode nodeA = new ListNode(1);
        nodeA.next = new ListNode(3);
        nodeA.next.next = new ListNode(5);
        nodeA.next.next.next = new ListNode(7);
        nodeA.next.next.next.next = new ListNode(9);
        nodeA.next.next.next.next.next = new ListNode(11);

        ListNode nodeB = new ListNode(2);
        nodeB.next = new ListNode(4);
        nodeB.next.next = new ListNode(6);
        nodeB.next.next.next = new ListNode(8);
        nodeB.next.next.next.next = new ListNode(10);
        nodeB.next.next.next.next.next = new ListNode(12);

        ListNode newHead = solve(nodeA, nodeB);
        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }
}
