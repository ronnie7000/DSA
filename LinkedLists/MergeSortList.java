package LinkedLists;

public class MergeSortList {

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = getMid(head);
        ListNode h1 = head;
        ListNode h2 = midNode.next;
        midNode.next = null;
        h1 = mergeSort(h1);
        h2 = mergeSort(h2);
        return merge(h1, h2);
    }

    public static ListNode getMid(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        return prev;
    }

    public static ListNode merge(ListNode nodeA, ListNode nodeB) {
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
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(6);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(2);

        ListNode newHead = mergeSort(node);
        while (newHead != null) {
            System.out.println(newHead.data);
            newHead = newHead.next;
        }
    }
}
