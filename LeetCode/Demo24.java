package LeetCode;

/**
 * @author 24.两两交换链表中的节点
 * @description: TODO
 * @date 2025/3/21 11:15
 */
public class Demo24 {

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
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {

        ListNode pre = new ListNode(0, head);
        ListNode node0 = pre;
        ListNode node1 = head;

        while (node1 !=null && node1.next != null){

            //node1 和 node2 是需要交换的节点
            //node0 是 node1 的前一个节点
            //node3 是 node2 的下一个节点
            ListNode node2 = node1.next;
            ListNode node3 = node2.next;

            node0.next = node2;
            node2.next = node1;
            node1.next = node3;
            node0 = node1;
            node1 = node3;
        }
        return pre.next;

    }
}
