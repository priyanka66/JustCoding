package Easy;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesUnsorted {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static ListNode removeDupFromUnsorted(ListNode head) {
        if (head ==  null) return null;
        ListNode cur = head.next, prev = head, temp;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                prev.next = cur.next;
                temp = cur;
                temp.next = null;
            } else {
                set.add(cur.val);
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(3);
        l1.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next = new ListNode(4);
        l1.next.next.next.next.next.next = new ListNode(5);


        ListNode result = removeDupFromUnsorted(l1);
        while (result != null) {
            System.out.println(result.val);
            result =result.next;
        }
    }
}
