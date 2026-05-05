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
    void solve(ListNode *&root){
        ListNode *head=root;
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
        ListNode *tail=head;
        while(tail->next != NULL){
            size++;
            tail=tail->next;
        }
        tail->next=head;
        k%=size;
        for(int i=0; i<size-k; i++){
            tail=tail->next;
        }
        head=tail->next;
        tail->next=NULL;
        return head;
    }
};
















