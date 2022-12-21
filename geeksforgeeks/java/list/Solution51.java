package geeksforgeeks.java.list;

/*
 * Absolute List Sorting : 21 Dec 2022
 */
public class Solution51 {
    Node sortList(Node head) {
        // Your code here
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.data < 0 && curr != head) { 
                prev.next = curr.next;
                curr.next = head;
                head = curr;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
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