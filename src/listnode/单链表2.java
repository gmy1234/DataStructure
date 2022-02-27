package listnode;

/**
 * @version 1.0
 * @Description: gmy
 * @Author gmyDL
 * @Date 2022/2/27 16:54
 */
public class 单链表2 {
    public static void main(String[] args) {

        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        ListNode t5 = new ListNode(5);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;
        t4.next = t5;
        t5.next = new ListNode(3);

        final ListNode listNode = deleteDuplicates(t1);
        System.out.println(listNode);

    }


    /**
     * 给定一个 !!已排序 !!的链表的头 head, 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
     * @param head 链表的头 head
     * @return 无重复元素的链表
     */
    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return  null;
        }
        ListNode cur = head;
        while (cur.next != null) {

            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
     * @param head 链表的头
     * @return 结果
     */
    public static ListNode deleteDuplicatesII(ListNode head) {
        final ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;

        while ( cur.next != null && cur.next.next != null  ) {
            // cur.next 和 cur.next.next 不相等
            if (cur.next.val != cur.next.next.val) {
                cur = cur.next;
            }else {
                // 相等
                int equalValue = cur.next.val;
                while (cur.next != null && cur.next.val == equalValue) {
                    cur.next = cur.next.next;
                }
            }
        }

        return dummy.next;
    }


}
