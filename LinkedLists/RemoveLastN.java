package LinkedLists;

public class RemoveLastN {

    public static ListNode solve(ListNode A, int B) {
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if(size <= B)
            return A.next;
        int pos = size - B + 1;
        int i = 1;
        temp = A;
        ListNode prev = A;
        while (i < pos) {
            prev = temp;
            temp = temp.next;
            i++;
        }
        prev.next = temp.next;
        temp.next = null;
        return A;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        ListNode head = solve(node, 1);
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }
}
