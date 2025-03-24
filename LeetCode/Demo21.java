package LeetCode;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/**
 * @author chuYun
 * @description: 21.合并两个有序链表
 * @date 2025/3/17 22:44
 */
public class Demo21 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val = val;
        };
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        };

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] split1 = sc.next().split(",");
        ListNode pre1  = new ListNode(-1);
        ListNode head1 = pre1;
        for(String s : split1){
            head1.next = new ListNode(parseInt(s));
            head1 = head1.next;
        }
        String[] split2 = sc.next().split(",");
        ListNode pre2  = new ListNode(-1);
        ListNode head2 = pre2;
        for(String s : split2){
            head2.next = new ListNode(parseInt(s));
            head2 = head2.next;
        }
        System.out.println("List1:");
        ListNode head = pre1.next;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("List2:");
        ListNode head3 = pre2.next;
        while(head3 != null){
            System.out.print(head3.val + " ");
            head3 = head3.next;
        }

        ListNode res = mergeTwoLists(pre1.next, pre2.next);
        while(res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }


    }

    /**
     * 3 6 9
     * 1 2 5 8
     *
     * 同时遍历两个链表
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //定义一个头节点，方便返回结果
        ListNode head = new ListNode(0);
        ListNode cur = head;

        while (list1!=null && list2!=null){

            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return head.next;
    }
}
