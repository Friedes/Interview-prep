package leetcode.java.structure;

/*
 * Swap Nodes in Pairs : Data structure Day 12 > 12 Nov 2022
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;

        while (temp != null && temp.next != null) {
            int k = temp.val;
            temp.val = temp.next.val;
            temp.next.val = k;
            temp = temp.next.next;
        }
        return head;
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
}


