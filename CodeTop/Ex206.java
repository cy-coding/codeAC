package CodeTop;

import java.util.List;
import java.util.Scanner;

/**
 * @author chuYun
 * @description: 206.翻转链表
 * @date 2025/5/13 10:54
 */


class ListNode{
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
public class Ex206 {
    public static void main(String[] args){
        // 控制台输入
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        for(String s : split){
            cur.next = new ListNode(Integer.parseInt(s));
            cur = cur.next;
        }
        ListNode head1 = reverseList(pre.next);
//        // 手动构建
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = null;
//        ListNode head1 = reverseList(node1);

        while(head1 != null){
            System.out.print(head1.val + " ");
            head1 = head1.next;
        }
    }
    // 翻转链表
    private static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode  temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
