package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chuYun
 * @description: TODO
 * @date 2025/3/23 16:41
 */
public class Demo138 {

    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }





    public static void main(String[] args) {



    }

    /**
     * 时间O(n)
     * 空间O(n)
     * @param head
     * @return
     */

    public Node copyRandomList(Node head) {

        if (head == null) return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();

        // 复制各个节点，建立原节点--》新结点到影视
        while (cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 构建新链表的next random指向
        while (cur != null){
            // 新节点的next
            map.get(cur).next = map.get(cur.next);
            // 新结点的random
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;

        }
        //
        return map.get(head);
    }
}
