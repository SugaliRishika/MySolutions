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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode KThNode=getKthElement(temp,k);
            if(KThNode==null){
                if(prev!=null){
                    prev.next=temp;
                    break;
                }
            }
            ListNode nextNode=KThNode.next;
            KThNode.next=null;
            reverseLinkedList(temp);
            if(temp==head){
                head=KThNode;
            }else{
                prev.next=KThNode;
            }
            prev=temp;
            temp=nextNode;
        }
        return head;
    }

    public void reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode nextNode=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
    }

    public ListNode getKthElement(ListNode temp,int k){
        k=k-1;
        while(temp!=null & k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
}