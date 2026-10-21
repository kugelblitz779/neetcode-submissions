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
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        // NEW: find the end of the first half
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // CHANGED: reverse only the second half, and cut the first half off
        ListNode last = reverse(slow.next);
        slow.next = null;

        merge(head, last);
    }

    //2, 4, 6, 8
    //8, 6, 4, 2

    public ListNode merge(ListNode start, ListNode end){

        ListNode lo = start;
        ListNode hi = end;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        boolean even = true;

        while(lo != null || hi != null){
            if(even){
                curr.next = lo;
                lo = lo.next;
            }else{
                curr.next = hi;
                hi = hi.next;
            }
            curr = curr.next;
            even = !even;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode head){

        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}





