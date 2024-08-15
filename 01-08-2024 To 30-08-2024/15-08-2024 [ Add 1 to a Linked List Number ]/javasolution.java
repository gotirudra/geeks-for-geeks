class Solution {
    public Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        if (head.data == 9 && head.next == null) {
            Node newNode = new Node(0);
            head.data = 1;
            head.next = newNode;
            return head;
        }
        if (head.next == null) {
            head.data = head.data + 1;
            return head;
        }
        head = reverse(head);
        int carry = 0;
        Node temp = head;
        int val = carry + 1 + temp.data;
        carry = val / 10;
        temp.data = val % 10;
        temp = temp.next;
        while (temp.next != null && carry != 0) {
            val = carry + temp.data;
            carry = val / 10;
            temp.data = val % 10;
            temp = temp.next;
        }
        val = temp.data + carry;
        carry = val / 10;
        temp.data = val % 10;
        if (carry != 0) {
            Node newNode = new Node(carry);
            temp.next = newNode;
        }
        head = reverse(head);
        return head;
    }
}

