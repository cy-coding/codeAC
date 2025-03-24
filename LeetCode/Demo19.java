package LeetCode;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/21 10:42
 */
public class Demo19 {

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

    /**
     * @param args
     */

    public static void main(String[] args) {


    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * 方法1：正序遍历一遍链表，得到链表长度，倒数第n个节点 ，即为正数第 m-n+1 个节点
     *
     * 方法2：
     * 定义一个start指针，end指针指向第一个节点，慢指针指向第n个节点，
     *  同时移动两个节点，当end指向尾节点的时候，start指向倒数第n个节点
     * @param head
     * @param n
     * @return
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        while (n > 0){
            end = end.next;
            n--;
        }
        while (end.next != null){
            start = start.next;
            end = end.next;
        }
        //结束循环，start指向被删除节点的前一个节点，;
        start.next = start.next.next;
        return pre.next;

    }

}
