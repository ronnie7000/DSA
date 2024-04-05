package LinkedLists;

public class TortoiseHare {

    public static int getMid(ListNode head) {
        int ans = 0;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ans = slow.data;
        return ans;
    }

    public static int getMid2(ListNode head) {
        int ans = 0;
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        int mid = size / 2;
        temp = head;
        int i = 1;
        while (i <= mid) {
            temp = temp.next;
            i++;
        }
        ans = temp.data;
        return ans;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);

        System.out.println(getMid2(node));
    }

}