/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution{
public:
    void solve(ListNode *&head){
        
        ListNode *prev=NULL, *tail=head;
        while(tail != NULL && tail->next != NULL){
            prev=tail;
            tail=tail->next;
        }
        prev->next=NULL;
        tail->next=head;
        head=tail;
    }

    ListNode *rotateRight(ListNode *head, int k){
        if(head == NULL)
            return NULL;
        int size=1;
        ListNode *temp=head;
        while(temp->next != NULL){
            size++;
            temp=temp->next;
        }
        k%=size;
        while(k--){
            solve(head);
        }

        return head;
       
    }
};
















