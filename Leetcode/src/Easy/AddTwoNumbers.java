package Easy;

public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode result = start;
        int carry = 0;
        int sum = 0;
        while ((l1!=null) || (l2!=null)) {
            int val1 = 0, val2 =0;
            if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                val2 = l2.val;
                l2 = l2.next;
            }

            sum = (val1+val2+carry) % 10;
            carry = (val1 + carry + val2) / 10;
            result.next = new ListNode(sum);
            result = result.next;
        }

        return start.next;
    }
    public static void main(String[] args) {

        AddTwoNumbers a1 = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = a1.addTwoNumbers(l1, l2);
        while (result!= null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
}

