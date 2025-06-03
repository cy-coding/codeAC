package CodeTop;
import CodeTop.ListNode;

/**
 * @author chuYun
 * @description: 21.合并两个有序链表
 * @date 2025/6/3 20:27
 */
public class Ex21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 定义一个头节点，便于返回结果
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null){
            if(list1.val <= list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 将剩余的那个拼到后边
        cur.next = list1 != null ? list1 : list2;
        return head.next;
    }
}
