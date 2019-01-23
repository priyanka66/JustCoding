package Medium;

import java.util.List;

public class AddTwoNumbers11 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int len1 = getLength(l1), len2 = getLength(l2);
        ListNode result;
        if (len1 < len2) {
            result = addTwoNumbers(l1, l2, len2-len1);
        } else {
            result = addTwoNumbers(l2, l1, len1-len2);
        }
        if (carry > 0) {
            ListNode res1 = result;
            result = new ListNode(carry);
            result.next = res1;
        }
        return result;


    }

    ListNode addTwoNumbers(ListNode l1, ListNode l2, int diff)  {
        if (l1.next == null && l2.next  == null) {
            int sum = l1.val + l2.val;
            carry = sum / 10;
            return new ListNode(sum % 10);
        }
        ListNode res, next;
        int sum;
        if (diff == 0) {
            next = addTwoNumbers(l1.next,l2.next, 0);
            sum = l1.val+l2.val+carry;
        } else {
            next = addTwoNumbers(l1, l2.next, diff-1);
            sum = carry + l2.val;
        }

        carry  = sum/10;
        res = new ListNode(sum % 10);
        res.next = next;
        return res;


    }

    private int getLength(ListNode l1) {
        int count = 0;
        while (l1 != null) {
            count++;
            l1 = l1.next;
        }

        return count;
    }

    public static void main(String[] args) {
        AddTwoNumbers11 n = new AddTwoNumbers11();

        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = n.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
