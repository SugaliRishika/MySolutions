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
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode ldummy=new ListNode(69);
        ListNode rdummy=new ListNode(69);
        ListNode less=ldummy;
        ListNode more=rdummy;
        ListNode moreh=rdummy;
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                less.next=new ListNode(temp.val);
                less=less.next;
            }else{
                more.next=new ListNode(temp.val);
                more=more.next;
            }
            temp=temp.next;
        }
        if(moreh.next!=null){
            moreh.val=moreh.next.val;
            moreh.next=moreh.next.next;
            less.next=moreh;
        }
        
        return ldummy.next;
    }
}