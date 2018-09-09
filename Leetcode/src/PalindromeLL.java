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

    public static void main (String[] args) {
        PalindromeLL p = new PalindromeLL();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(p.isPalindrome(head));

    }
}
