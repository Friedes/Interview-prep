package leetcode.java.structure;

/*
 * Reverse Nodes in k-Group : Data structure Day 13 > 13 Nov 2022
 */
public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;

        int length = 0;
        ListNode temp = head;
        ListNode newHead = head;
        while (temp != null) {
            length++;
            if (length == k)
                newHead = temp;
            temp = temp.next;
        }

        int size = length / k;
        int outerCount = 0;
        int innerCount = 0;

        ListNode start = null, prev = null, next = null;
        ListNode current = head, lastStart = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

            outerCount++;

            if (outerCount % k == 0) {
                if (start == null)
                    start = head;
                else {
                    start.next = prev;
                    start = lastStart;
                }
                lastStart = current;
                innerCount++;
                if (innerCount == size) {
                    start.next = current;
                    break;
                }
            }
        }
        return newHead;
    }

    public class ListNode {
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
}
