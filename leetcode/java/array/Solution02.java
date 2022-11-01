package leetcode.java.array;

/*
 * Problem 02 : add two numbers
 */
public class Solution02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        int num1 = 0;
        int num2 = 0;
        int digit = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {
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
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}