class Solution {
    
    int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        int abc = 0;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                slow = head;
                
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                
                abc = 1;
                break;
            }
        }
        
        if (abc == 1) {
            int count = 1;
            Node a = slow.next;
            
            while (a != slow) {
                count++;
                a = a.next;
            }
            
            return count;
        } else {
            return 0;
        }
    }
}
