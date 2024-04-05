package LinkedLists;

public class IsPalindrome {

    public static int solve(ListNode A) {
        // Get size and middle node
        int size = 0;
        ListNode temp = A;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        if (size == 1)
            return 1;
        int mid = size / 2;
        temp = A;
        for (int i = 1; i < mid; i++) {
            temp = temp.next;
        }
        ListNode B = null;
        if (size % 2 == 0) {
            B = temp.next;

        } else {
            B = temp.next.next;
        }
        temp.next = null;

        // Reverse second half
        B = reverseList(B);

        ListNode tempA = A, tempB = B;
        while (tempA != null || tempB != null) {
            if (tempA.data != tempB.data)
                return 0;
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return 1;
    }

    public static ListNode reverseList(ListNode A) {
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
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);

        System.out.println(solve(node));

    }
}
