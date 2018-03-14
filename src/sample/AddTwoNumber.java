package sample;

/**
 * Created by chen on 2018/3/7.
 */
public class AddTwoNumber {

    public static void main(String[] args) {

    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    /* 递归方式 -- 56ms
    *
    * @param l1
    * @param l2
    * @return
            */
    public  ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int value = l1.val + l2.val;
        ListNode result = new ListNode(value % 10);
        result.next = addTwoNumbers2(l1.next, l2.next);
        if (value >= 10) {
            result.next = addTwoNumbers2(new ListNode(value / 10), result.next);
        }
        return result;
    }

}
