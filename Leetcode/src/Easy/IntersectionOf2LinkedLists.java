package Easy;

import java.util.LinkedHashSet;
import java.util.Set;

public class IntersectionOf2LinkedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;
        Set<ListNode> nodes = new LinkedHashSet<ListNode>();
        while(headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (!nodes.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }

    private ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;

        while (a!=b) {
            if (a != null) a = a.next;
            else a = headB;
            if (b != null) b = b.next;
            else b = headA;
        }

        return a;
    }

    public static void main(String[] args) {
        IntersectionOf2LinkedLists i = new IntersectionOf2LinkedLists();
        ListNode headA = new ListNode(1);
        headA.next = new ListNode(2);
        headA.next.next = new ListNode(3);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
        headA.next.next.next.next.next = new ListNode(6);


        ListNode headB = new ListNode(7);
        headB.next = new ListNode(8);
        headB.next.next = new ListNode(3);
        headB.next.next.next = headA.next.next.next;

        ListNode result = i.getIntersectionNode(headA, headB);
        System.out.println(result);

        ListNode result1 = i.getIntersectionNodeV2(headA, headB);
        System.out.println(result1);


    }
}
