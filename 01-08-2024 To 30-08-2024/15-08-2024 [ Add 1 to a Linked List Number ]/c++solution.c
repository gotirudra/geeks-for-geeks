class Solution {
  public:
  Node*reverse(Node*head){
        Node*curr=head;
        Node*prev=NULL;
        Node*next=NULL;
        while(curr!=NULL){
            next=curr->next;
            curr->next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    Node* addOne(Node* head) {
       if(head->data==9&&head->next==NULL){
            Node*newNode=new Node(0);
            head->data=1;
            head->next=newNode;
            return head;
        }
        if(head->next==NULL){
            head->data=head->data+1;
            return head;
        }
        head=reverse(head);
        int carry=0;
        Node*temp=head;
        int val=carry+1+temp->data;
        carry=val/10;
        temp->data=val%10;
        temp=temp->next;
        while(temp->next!=NULL&&carry!=0){
            val=carry+temp->data;
            carry=val/10;
            temp->data=val%10;
            temp=temp->next;
        }
         val=temp->data+carry;
         carry=val/10;
         temp->data=val%10;
        if(carry!=0){
            Node*newNode=new Node(carry);
            temp->next=newNode;
        }
         head=reverse(head);
         return head;
    }
};
