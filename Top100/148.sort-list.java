/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode pre=null,slow,fast;
        
        slow=head;
        fast=head;
        //取中点
        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        //截断中点之前
        pre.next=null;
        //slow是中点
        return merge(sortList(head),sortList(slow));
    }
    
    public ListNode merge(ListNode l1,ListNode l2){
        //结果l，而p是指针（做处理的具体位置）
        ListNode l = new ListNode(0), p = l;

        while(l1 != null && l2 != null){
            //把l1和l2的开头比较，最小的加入p，加入后后移一位
            //继续执行，直到其中一个为空结束
            if(l1.val<l2.val){
                p.next = l1;
                l1=l1.next;
            }else{
                p.next = l2;
                l2=l2.next;
            }
            //指针后移
            p=p.next;
        }
        //如果l1还有剩余，加到后边
        if(l1!=null){
            p.next = l1;
        }
        //如果l2还有剩余，加到后边
        if(l2!=null){
            p.next = l2;
        }
        //返回处理结果，即排好序的子串
        return l.next;
    }
}
// @lc code=end

