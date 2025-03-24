package LeetCode;

import java.util.List;

/**
 * @author chuYun
 * @description: 148.排序链表
 * @date 2025/3/23 17:00
 */
public class Demo148 {

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
     *
     * @param head
     * @return
     */

    public ListNode sortList(ListNode head) {
        // 获取链表长度
        int length = getListLength(head);
        // 表头节点
        ListNode pre = new ListNode(0, head);

        //开始归并-->从步长为1开始
        for(int step = 1; step < length; step = step * 2){
            ListNode newListTail = pre; //新链表的末尾节点
            ListNode cur = pre.next; // 每轮循环的起始节点

            // 在step为1的情况下，对整个链表经行依次归并
            while (cur != null){

                // 从cur开始分割出两段长为step的链表，头节点分别为head1、head2
                ListNode head1 = cur;
                // 分割head1  head1长度为step  head长度为length-step
                ListNode head2 = splitList(head1, step);
                // 在分割head2  head长度为step  cur为剩余链表的头节点
                cur = splitList(head2, step);

                // 合并head1 和 head 2
                // 合并之后需要返回合并后的链表的头节点和尾节点，将子链表串联起来形成整个链表
                ListNode[] merged = mergeTwoLists(head1, head2);

                newListTail.next  = merged[0];
                newListTail = merged[1]; // 新链表的末尾

            }
        }
        return pre.next;
    }

    /**
     * 合并head1 和 head 2  -- 升序
     * 合并之后需要返回合并后的链表的头节点和尾节点
     *
     * @param head1
     * @param head2
     * @return
     */

    private ListNode[] mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        while (head1 != null && head2 != null){
            if(head1.val <= head2.val){
                cur.next = head1;
                head1 = head1.next;
            }else{
                cur.next = head2;
                head2 = head2.next;
            }

            cur = cur.next;

        }
        //跳出循环说明有一个空了
        cur.next = head1 != null ? head1 : head2;
        // 拼接剩余链表
        while (cur.next != null){
            cur = cur.next;
        }

        return new ListNode[]{pre.next, cur};

    }

    /**
     * 分割链表
     * 如果链表长度 <= step，不做任何操作，返回空节点
     * 如果链表长度 > step，把链表的前 size 个节点分割出来（断开连接），并返回剩余链表的头节点
     * @param head1
     * @param step
     * @return
     */
    private ListNode splitList(ListNode head, int step) {
        ListNode cur = head;

        // 找到需要分割出来子链表的尾节点
        for(int i = 0; i < step-1 && cur != null ; i++){
            cur = cur.next;
        }

        // 果链表长度 <= step
        if(cur == null || cur.next == null){
            return null; // 返回空节点
        }
        ListNode nextHead = cur.next;
        cur.next = null; // 断开连接点
        return nextHead;

    }

    /**
     * 获取链表长度
     * 传入链表头节点
     * @return
     */

    private int getListLength(ListNode head){

        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }




}
