package Easy;

import java.util.Stack;

public class PalindromeLL {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        Stack<ListNode> st = new Stack<>();
        ListNode cur = head;
        while (cur!=null) {
            st.push(cur);
            cur = cur.next;
        }

        while (!st.isEmpty() || head != null) {
            cur = st.pop();
            if (cur.val != head.val) return false;
            head = head.next;
        }

        return true;
    }

    private boolean isPalindromeV2(ListNode head) {
        if (head == null) return true;
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        int mid = count/2;
        if (count % 2 != 0) mid++;
        count = 0;
        ListNode head2 = head;
        while (count != mid) {
            head2 = head2.next;
            count++;
        }

        ListNode rev = reverseLL(head2);
        while (head != null && rev != null && head.val == rev.val) {
            head = head.next;
            rev = rev.next;
        }

        if (rev == null) return true;
        return false;
    }

    private ListNode reverseLL(ListNode head) {
        if (head == null) return null;
        ListNode cur = head, prev=null, next;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        head = prev;
        return head;
    }
    public static void main (String[] args) {
        PalindromeLL p = new PalindromeLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        ListNode node = head;

//        System.out.println(p.isPalindrome(node));

        System.out.println(p.isPalindromeV2(node));
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }

    }
}
