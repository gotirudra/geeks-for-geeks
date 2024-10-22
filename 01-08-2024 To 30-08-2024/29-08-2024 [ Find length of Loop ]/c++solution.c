
class Solution {
  public:
   
    int countNodesinLoop(struct Node *head) {
        // Code here
        Node* slow = head;
        Node* fast = head;
        int abc=0;
        while (fast!= NULL && fast->next!= NULL ) {
            slow = slow->next;
            fast = fast->next->next;
            if (slow == fast) {
                slow=head;
                while(slow!=fast){
                    slow=slow->next;
                    fast=fast->next;
                }
                abc=1;
                break;
            }
        }
        if(abc==1){
            int count=1;
            Node* a=slow->next;
            while(a!=slow){
                count++;
                a=a->next;
            }
            return count;
        }
        else{
            return 0;
        }
        
    }
};
