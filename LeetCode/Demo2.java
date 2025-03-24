package LeetCode;

/**
 * @author chuYun
 * @description: 2.两数相加
 * @date 2025/3/21 9:56
 */
public class Demo2 {

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
        System.out.println(12/10);
        System.out.println(12%10);

    }

    /**
     * 个 十 百
     * 注意点：最后可能多出一个进位
     * 时间O(Max(M,N))
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(0);
        ListNode temp = pre;
        int carry = 0;

        while (l1 != null || l2!=null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = (x + y + carry) % 10; //当前位
            carry = (x + y + carry) / 10; //进位
            temp.next = new ListNode(sum);
            temp = temp.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry > 0){
            temp.next = new ListNode(carry);
        }

        return pre.next;
    }


}
