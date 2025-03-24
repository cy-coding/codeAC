package LeetCode;

import java.util.List;
import java.util.Scanner;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/17 21:18
 */
public class Demo206 {

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
        ListNode head1 = reverseList(head);

        while(head1 != null){
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }

    }
    // 时间O(n)
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur!=null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
