class Solution {
  public:

    Node* rotate(Node* head, int k) {
    int ct=1;
        Node*temp=head;
        while(ct<k){
            ct++;
            temp=temp->next;
        }
        if(temp->next==NULL)return head;
        Node*last=temp->next;
        Node*t=last;
        temp->next=NULL;
        while(last->next!=NULL)last=last->next;
        last->next=head;
        return t;
    }
};
