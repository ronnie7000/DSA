package LinkedLists;

public class AddNumber {
    public static ListNode solve(ListNode A, ListNode B){
        ListNode h1 = A, h2 = B;
        int sum = 0, carry = 0;
        // ListNode head = new ListNode(0);
        // ListNode temp = head;
        return A;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        node1.next = new ListNode(9);
        node1.next.next = new ListNode(1);
        
        ListNode node2 = new ListNode(1);
        ListNode ans = solve(node1, node2);

        while(ans != null){
            System.out.println(ans.data);
            ans = ans.next;
        }
    }
}
