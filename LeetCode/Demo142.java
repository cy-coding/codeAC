package LeetCode;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/17 22:18
 */
public class Demo142 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 快慢指针，两个指针相遇的时候，肯定是在坏内
     * 假设，从头节点到环入口节点走a步，环长b
     * 相遇时：fast比slow多走了q*b步
     * fase = slow + q*b
     * fast = 2slow
     * slow = q*b
     * 重合时 fast 比 slow 多走 环的长度整数倍
     * 当分别再次进入环口节点时：
     *  fast=a+n*b
     *  slow=a+m*b
     *  slow = q*b
     *  则相遇时候，slow 再走 a 步停下来，就可以到环的入口。
     *  时间O(n)
     * @param head
     * @return
     */

    public ListNode detectCycle(ListNode head) {

        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        // 跳出循环的时候，相遇了
        fast = head;
        while (slow!=fast){
            fast = fast.next; //fase 走a步
            slow = slow.next;
        }
        return fast;
    }

}
