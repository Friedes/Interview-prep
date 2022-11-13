package leetcode.java.structure;

/*
 * Reorder List : Data structure Day 13 > 13 Nov 2022
 */
public class Solution143 {

    public void reorderList(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        curr = head;
        int halfLen = (len & 0x1) != 0 ? len / 2 + 1 : len / 2;
        while (halfLen-- > 0)
            curr = curr.next;
        ListNode pre = null, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        ListNode dummy = new ListNode(-1), tmp = dummy;
        curr = head;
        int hLen = len / 2;
        while (hLen-- > 0) {
            tmp.next = curr;
            curr = curr.next;
            tmp = tmp.next;
            tmp.next = pre;
            pre = pre.next;
            tmp = tmp.next;
        }
        if ((len & 0x1) != 0) {
            tmp.next = curr;
            tmp = tmp.next;
        }
        tmp.next = null;

        head = dummy.next;
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
