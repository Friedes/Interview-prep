package leetcode.java.structure;

/*
 * Add Two Numbers : Data structure Day 10 > 10 Nov 2022
 */
public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy, p = l1, q = l2;
        while (p != null || q != null) {
            int sum = (p == null ? 0 : p.val) + (q == null ? 0 : q.val) + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0)
            curr.next = new ListNode(carry);
        return dummy.next;
    }

    //Nov 10 2019
    public ListNode oldAddTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int num1 = 0;
        int num2 = 0;
        int digit = 0;
        int carry = 0;
        while(l1 != null || l2 != null) {
            if (l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            } else {
                num1 = 0;
            }
            if (l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            } else {
                num2 = 0;
            }
            digit = num1 + num2 + carry;
            if (digit < 10) {
                carry = 0;
            } else {
                carry = 1;
                digit -= 10;
            }
            if (head == null) {
                head = tail = new ListNode(digit);
            } else {
                tail.next = new ListNode(digit);
                tail = tail.next;
            }
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head;
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
