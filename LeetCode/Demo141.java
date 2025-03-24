package LeetCode;

import java.util.Scanner;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/17 22:01
 */
public class Demo141 {

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
        Scanner sc = new Scanner(System.in);
        String[] split = sc.next().split(",");

    }

    /**
     * 可以使用快慢指针，如果有环，则一定会相遇
     * 时间O(n)
     * @param head
     * @return
     */

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

}
