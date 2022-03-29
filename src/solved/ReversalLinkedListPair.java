package solved;

public class ReversalLinkedListPair {

    public static void main(String[] args) {
        int arr[] = {};
        ListNode head =getHead(arr);
        // new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5, new ListNode(6, null))))));
        head = reversePair(head);
        ListNode node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
        //System.out.println(head.data + "" + head.next.data);
    }

    private static ListNode reversePair(ListNode head) {
        ListNode later = head;
        ListNode current = head;
        ListNode next;
        ListNode prev = null;
        while (true) {
            if (later == null) return head;
            current = later;
            if (later.next == null) return head;
            next = later.next;
            later = next.next;

            current.next = later;
            next.next = current;
            if (prev == null) head = next;
            else prev.next = next;

            prev = current;
        }
    }

    public static ListNode getHead(int arr[]) {
        ListNode head = null;
        ListNode prev = null;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i], null);
            if (head == null) head = node;
            if (prev != null) prev.next = node;
            prev = node;
        }
        return head;

    }
}

class ListNode {
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    int data;
    ListNode next;
}
