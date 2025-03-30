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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode t1=l1;
        ListNode t2=l2;
        ListNode dummyNode=new ListNode(-1);
        int carry=0;
        ListNode curr=dummyNode;
        while(t1!=null || t2!=null){
            int sum=carry;
            if(t1!=null){
                sum=sum+t1.val;
            }
            if(t2!=null){
                sum=sum+t2.val;
            }
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            curr.next=newNode;
            curr=curr.next;

            if(t1!=null){
                t1=t1.next;
            }
            if(t2!=null){
                t2=t2.next;
            } 
        }
        if(carry!=0){
            ListNode carryNode=new ListNode(carry);
            curr.next=carryNode;
        }
        return dummyNode.next;
    }
}