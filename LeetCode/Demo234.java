package LeetCode;

import java.util.List;
import java.util.Scanner;

/**
 * @author chuYun
 * @description: 234 回文链表
 * @date 2025/3/17 21:37
 */
public class Demo234 {

    // 链表节点结构
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

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] split = sc.next().split(",");
        ListNode pre = new ListNode(-1);
        ListNode head = pre;

        for(String s:split){
            head.next = new ListNode(Integer.parseInt(s));
            head = head.next;
        }
        head = pre.next;

//        while(head1 != null){
//            System.out.print(head1.val + " ");
//            head1 = head1.next;
//        }

    }

    /**
     *
     * @param head
     * @return
     */

    public boolean isPalindrome(ListNode head) {

        ListNode mid = middleNode(head);
        ListNode head2 = reverseList(mid);

        while (head2 != null){
            if(head.val != head2.val){
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }


    //翻转链表
     private ListNode reverseList(ListNode head){

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
     }



    // 876. 链表的中间结点
    // 快慢指针求链表的中间节点
    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
