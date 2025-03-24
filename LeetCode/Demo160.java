package LeetCode;

import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * @author chuYun
 * @description: 160.相交链表
 * @date 2025/3/17 20:00
 */
public class Demo160 {

    // 定义链表节点
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
        ListNode pre  = new ListNode(-1);
        ListNode head = pre;
        for(String s : split){
            head.next = new ListNode(parseInt(s));
            head = head.next;
        }


        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    /**
     * 如果两个链表相交，那么相交点之后的长度是相同的
     *
     * 我们需要做的事情是，让两个链表从同距离末尾同等距离的位置开始遍历。这个位置只能是较短链表的头结点位置。
     * 为此，我们必须消除两个链表的长度差
     *
     * 指针 pA 指向 A 链表，指针 pB 指向 B 链表，依次往后遍历
     * 如果 pA 到了末尾，则 pA = headB 继续遍历
     * 如果 pB 到了末尾，则 pB = headA 继续遍历
     * 比较长的链表指针指向较短链表head时，长度差就消除了
     * 如此，只需要将最短链表遍历两次即可找到位置
     *
     * 时间0(m+n)
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p!=q){
            p = p!=null ? p.next : headB;
            q = q!=null ? q.next : headA;
        }
        return p;
    }


}
