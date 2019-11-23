/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //When fast and slow meet at point p, the length they have run are 'a+2b+c' and 'a+b'.
    //Since the fast is 2 times faster than the slow. 
    //So a+2b+c == 2(a+b), then we get 'a==c'.
    //So when another slow2 pointer run from head to 'q', at the same time, previous slow pointer will run from 'p' to 'q', so they meet at the pointer 'q' together.
    //_____a________Q____b____P
    //              |         |
    //              |____c____|
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
                    
            if (fast == slow){
                ListNode slow2 = head; 
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
// @lc code=end

