class Solution {
    
    Node rotate(Node head, int k) {
        if (head == null || k == 0) return head;

        Node temp = head;
        int count = 1;

        while (count < k && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) return head;

        Node newHead = temp.next;
        temp.next = null; 

        Node last = newHead;
        while (last.next != null) {
            last = last.next;
        }

        last.next = head;

        return newHead;
    }
}
