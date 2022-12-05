package leetcode.java.twopointers;

/*
 * Middle of the Linked List : Daily > 4 Nov 2022
 */
public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode n = head;
        int count = 1;
        while (n != null) {
            n = n.next;
            count++;
        }

        int middle;
        if (count % 2 == 0)
            middle = count / 2;
        else
            middle = count / 2 + 1;

        count = 1;
        n = head;
        while (count != middle) {
            n = n.next;
            count++;
        }
        return n;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}