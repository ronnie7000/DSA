package LinkedLists;

public class RemoveDuplicatesSortedList {
    
    public static ListNode solve(ListNode A){
        ListNode temp = A;
        while(temp != null){
            ListNode nextNode = temp.next;
            while(nextNode != null && nextNode.data == temp.data){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            temp = nextNode;
        }
        return A;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(2);

        ListNode head = solve(node);
        while(head != null){
            System.out.println(head.data);
            head = head.next;
        }
    }
}
