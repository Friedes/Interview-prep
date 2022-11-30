package geeksforgeeks.java.list;

/*
 * Reorder List : 30 Nov 2022
 */
public class Solution30 {
    // Your code here
    public Node middleNode(Node head) {
        Node f = head;
        Node s = head;
        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        return s;
    }

    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        return prev;
    }

    Node reorderlist(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = middleNode(head);
        Node hs = reverseList(mid);
        Node hf = head;
        while (hf != null && hs != null) {
            Node temp = hf.next;
            hf.next = hs;
            hf = temp;
            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }
        if (hf != null) {
            hf.next = null;
        }
        return head;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
