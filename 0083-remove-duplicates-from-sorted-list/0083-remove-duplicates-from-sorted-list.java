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
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next== null) return head;
        ListNode p=head;
        ListNode n=head.next;
        while(n!=null){
            if(p.val!=n.val){
                p.next=n;
                p=p.next;
                n=n.next;
            }else{
                n=n.next;
            }
        }
        if(p.next!=null) p.next=null;
        return head;
    }
}