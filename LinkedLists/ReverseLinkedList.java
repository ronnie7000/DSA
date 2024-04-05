package LinkedLists;

public class ReverseLinkedList {
    public static ListNode solve(ListNode A) {
        ListNode prev = null;
        ListNode curr = A;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        ListNode ans = solve(node);
        while(ans != null){
            System.out.println(ans.data);
            ans = ans.next;
        }
    }
}
