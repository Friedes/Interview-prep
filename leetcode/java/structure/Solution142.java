package leetcode.java.structure;

/*
 * Linked List Cycle II : Data structure Day 10 > 10 Nov 2022
 */
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;

        fast = fast.next.next;
        slow = slow.next;
        while (fast != slow) {
            if (fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
