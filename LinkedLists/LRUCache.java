package LinkedLists;

import java.util.HashMap;

public class LRUCache {

    static HashMap<Integer, ListNode> hm = new HashMap<>();
    static ListNode head = null, tail = null;
    static int M = 1;

    public static void addNode(Integer val) {
        if (hm.containsKey(val)) {
            ListNode node = hm.get(val);
            deleteNode(node);
            insertNode(node);
        } else {
            if (hm.size() == M) {
                hm.remove(head.data);
                deleteNode(head);
            }
            ListNode newNode = new ListNode(val);
            hm.put(val, newNode);
            insertNode(newNode);
        }
    }

    public static void deleteNode(ListNode node) {
        if(node.prev == null && node.next == null){
            head = null;
            tail = null;
        }
        else if (node.prev == null) {
           node.next.prev = null;
        } 
        else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }
    }

    public static void insertNode(ListNode node) {
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
    }

    public static void displayMemory() {
        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        addNode(1);
        // addNode(2);
        // addNode(3);

        displayMemory();

        addNode(2);

        System.out.println();
        displayMemory();
    }
}
