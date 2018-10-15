package Medium;

import java.awt.*;

public class OddEvenLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode oddEvenList(ListNode head) {

        if (head == null ) return head;
        ListNode odd = head, even = head.next;
        ListNode evenStart = head.next;
        while (even !=null && even.next !=null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even =  even.next;
        }

        odd.next = evenStart;
        return head;
    }

    private ListNode oddEvenListV2(ListNode head) {
        if (head == null) return head;
        ListNode even=head.next, odd=head, evenStart=even;
        while (even != null && even.next !=null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenStart;

        return head;
    }
        public static void main(String[] args) {
        OddEvenLinkedList o = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);


        ListNode result = o.oddEvenList(head);

        while (result != null) {
            System.out.print(" " + result.val);
            result = result.next;
        }
            ListNode head1 = new ListNode(1);
            head1.next = new ListNode(2);
            head1.next.next = new ListNode(3);
            head1.next.next.next = new ListNode(4);
            head1.next.next.next.next = new ListNode(5);
            head1.next.next.next.next.next = new ListNode(6);
        result = o.oddEvenListV2(head1);

        while (result != null) {
            System.out.print(" " + result.val);
            result = result.next;
        }
    }
}
