/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
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
    //假设两个指针，一快一慢，快的一次两步，慢的一次一步
    //那么这两个指针相当于一个静止，一个在用1的速度行走
    //那么只要有一个圈，他们必然会相遇
    //为什么不直接让一个静止一个速度为1呢？
    //因为并不是所有的结点都处于环上
    public boolean hasCycle(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null && runner.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
// @lc code=end

