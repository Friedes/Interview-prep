package leetcode.java.structure;

/*
 * Design Linked List : Data structure Day 12 > 12 Nov 2022
 */
public class Solution707 {
    public static void main(String[] arg){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(0);
    }
}

class MyLinkedList {
    class Node {
        int val;
        Node prev, next;

        Node(Node p, Node n, int v) {
            prev = p;
            next = n;
            val = v;
        }
    }

    private int size;
    private Node fh;

    public MyLinkedList() {
        size = 0;
        fh = new Node(null, null, -1);
        fh.next = fh.prev = fh;
    }

    public int get(int index) {
        if (index >= size)
            return -1;
        Node w = fh;
        for (; index-- != 0; w = w.next)
            ;
        return w.next.val;
    }

    public void addAtHead(int val) {
        insert(fh, fh.next, val);
    }

    public void addAtTail(int val) {
        insert(fh.prev, fh, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        Node w = fh;
        for (; index-- != 0; w = w.next)
            ;
        insert(w, w.next, val);
    }

    public void deleteAtIndex(int index) {
        if (index >= size)
            return;
        Node w = fh;
        for (; index-- != 0; w = w.next)
            ;
        w.next.next.prev = w;
        w.next = w.next.next;
        size--;
    }

    private void insert(Node p, Node n, int v) {
        p.next = n.prev = new Node(p, n, v);
        size++;
    }
}