# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def rotateRight(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if head is None or k == 0:
            return head
        size=1
        tail=head
        while tail.next:
            size+=1
            tail=tail.next

        tail.next=head
        k%=size
        for _ in range(size-k):
            tail=tail.next

        head=tail.next
        tail.next=None
        return head
        