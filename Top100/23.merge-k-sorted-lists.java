/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        //为空的时候
        if (lists == null || lists.length == 0) {
            return null;
        }
        //索引
        int begin = 0, end = lists.length - 1;
        //二分法合并
        while (begin < end) {
            //中间值
            int mid = (begin + end - 1) / 2;
            //首尾合并为一个新的
            for (int i = 0; i <= mid; i++) {
                lists[i] = merge2list(lists[i], lists[end - i]);
            }
            //长度缩短一半
            end = (begin + end) / 2;
        }
        //循环结束返回最终结果
        return lists[0];
    }

    //子过程，合并两个ListNode
    public ListNode merge2list(ListNode l1, ListNode l2) {
        //都为空，返回空
        if (l1 == null && l2 == null) {
            return null;
        }
        //一个为空，返回另一个
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //dummy存结果
        ListNode dummy = new ListNode(-1), cur = dummy;
        //都不为空
        while (l1 != null && l2 != null) {
            //l1的小，下一个就是l1的值
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }else{
                //否则就是l2的值
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }
        }
        //如果其中一个还有赋予的，直接加在末尾
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }
        //返回新的合并ListNode
        return dummy.next;
    }
}
// @lc code=end

