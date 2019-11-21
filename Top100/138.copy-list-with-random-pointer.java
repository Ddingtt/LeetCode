import java.util.Map;

/*
 * @lc app=leetcode id=138 lang=java
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    //!!!!!!!!!!完全不理解！！！！！！！！！！！
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node n = head;
        while (n!=null) {
            Node n2 = new Node(n.val);
            Node temp = n.next;
            n.next = n2;
            n2.next = temp;
            n = temp;
        }

        n = head;
        while (n != null) {
            Node n2 = n.next;
            if (n.random != null) {
                n2.random = n.random.next;
            }
            else{
                n2.random = null;
            }
            n = n.next.next;
        }

        Node n2 = head.next;
        n = head;
        Node head2 = head.next;
        while (n2 != null || n != null) {
            n.next = n.next.next;
            if (n2.next == null) {
                break;
            }
            n2.next = n2.next.next;

            n2 = n2.next;
            n = n.next;
        }
        return head2;
    }
}
// @lc code=end

