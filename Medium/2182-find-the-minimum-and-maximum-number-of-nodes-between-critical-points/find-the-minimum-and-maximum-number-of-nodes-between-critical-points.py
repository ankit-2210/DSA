# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def nodesBetweenCriticalPoints(self, head: Optional[ListNode]) -> List[int]:
        temp=[]
        prev=head
        curr=head.next
        c=1

        while curr is not None and curr.next is not None:
            if curr.val > prev.val and curr.val > curr.next.val:
                temp.append(c)
            if curr.val < prev.val and curr.val < curr.next.val:
                temp.append(c)

            c+=1
            prev=prev.next
            curr=curr.next

        if len(temp)<2:
            return [-1, -1]

        mn=float('inf')
        mx=temp[-1]-temp[0]
        for i in range(len(temp)-1):
            mn=min(mn, temp[i+1]-temp[i])

        return [mn, mx]