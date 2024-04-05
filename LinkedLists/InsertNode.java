package LinkedLists;

public class InsertNode {

    public static ListNode addNode(ListNode head, int pos, int val) {
        ListNode newNode = new ListNode(val);
        // no nodes in list
        if (head == null)
            return newNode;

        // insert at head
        if (pos == 0) {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        int i = 1;
        ListNode temp = head;
        while (i < pos) {
            temp = temp.next;
            i++;
        }

        // insert at end
        if (temp.next == null) {
            temp.next = newNode;
            newNode.prev = temp;
            return head;
        }

        // insert in between the list
        ListNode nextNode = temp.next;
        newNode.next = nextNode;
        newNode.prev = temp;
        nextNode.prev = newNode;
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode head = addNode(node, 3, 8);
        head = addNode(head, 0, 10);
        head = addNode(head, 7, 20);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
