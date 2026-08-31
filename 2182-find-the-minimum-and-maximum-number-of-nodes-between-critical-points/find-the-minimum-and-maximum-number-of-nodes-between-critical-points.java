/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution{
    public int[] nodesBetweenCriticalPoints(ListNode head){
        
        List<Integer> temp=new ArrayList<>();
        ListNode prev=head;
        ListNode curr=head.next;
        int c=1;
        while(curr != null && curr.next != null){
            if(curr.val > prev.val && curr.val > curr.next.val){
                temp.add(c);
            }
            if(curr.val < prev.val && curr.val < curr.next.val){
                temp.add(c);
            }

            c++;
            prev=prev.next;
            curr=curr.next;
        }

        if(temp.size()<2)
            return new int[]{-1, -1};

        int mn=Integer.MAX_VALUE;
        int mx=temp.get(temp.size()-1)-temp.get(0);
        for(int i=0; i<temp.size()-1; i++){
            mn=Math.min(mn, temp.get(i+1)-temp.get(i));
        }

        return new int[]{mn, mx};
    }
}














