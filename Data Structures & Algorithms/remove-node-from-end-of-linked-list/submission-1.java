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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode curr = head;

        // System.out.println(head.val);

        while(curr != null){
            count++;
            curr = curr.next;
        }

        int nodeToRemove = count - n;

        curr = head;
        ListNode prev = null;
        while(nodeToRemove-- > 0 && curr != null){
            prev = curr;
            curr = curr.next;
        }

        if(prev != null){
            prev.next = curr.next;
            curr = null;
        }else{
            head = head.next;
        }
    
        return head;
    }
}
