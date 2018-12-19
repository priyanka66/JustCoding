package Medium;

import static Medium.OddEvenLinkedList.ListNode;

public class RemoveNthNodeFromEndofList {

    private ListNode removeNthFromEnd(ListNode head, int n) {

    if (head == null) return null;
    if (head.next == null && n==1) return null;
    ListNode cur=head, prev=head;

       while (n>0) {
           cur = cur.next;
           n--;
       }

       if (cur == null) {
           head = head.next;
           return head;
       }
       while (cur.next != null) {
           cur = cur.next;
           prev = prev.next;
       }
       prev.next = prev.next.next;

       return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndofList r = new RemoveNthNodeFromEndofList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        int n = 3;
        ListNode result = r.removeNthFromEnd(head, n);
        while(result !=null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}
