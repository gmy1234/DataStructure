package listnode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        // final ListNode listNode = deleteDuplicates(t1);
        // System.out.println(listNode);

        ListNode h1 = new ListNode(1,new ListNode(3));
        ListNode h2 = new ListNode(2,new ListNode(5));
        ListNode h3 = new ListNode(5, new ListNode(10));

        ListNode testResult = mergeTwoList(h1, h2);

        while (testResult != null) {
            System.out.println(testResult.val);
            testResult = testResult.next;
        }


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

    /**
     * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
     * 并且每个节点只能存储一位数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }


    /**
     * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
     *
     * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
     */
    public boolean isPalindrome(ListNode head) {

        List<Integer> vals = new ArrayList<Integer>();

        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = vals.size() - 1;

        while (left < right) {
            if (!vals.get(left).equals(vals.get(right))){
                return false;
            }
            left ++;
            right --;
        }

        return true;
    }


    /**
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */
    public static int[] reversePrint(ListNode head) {

        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int[] result = new int[stack.size()];

        int i = 0;
        while (!stack.isEmpty()){
            result[i] = stack.pop().val;
            i ++;

        }
        return result;
    }


    /**
     * 合并两个有序链表
     * @param head1 链表 1
     * @param head2 链表 2
     * @return 合并后的链表
     */
    private static ListNode mergeTwoList(ListNode head1, ListNode head2){
        // 哨兵
        ListNode pre = new ListNode(-1);
        ListNode temp = pre;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                // 放入pre
                temp.next = head1;
                head1 = head1.next;
            }else {
                temp.next = head2;
                head2 = head2.next;
            }
            // pre 链表执行指到下一个
            temp = temp.next;
        }

        temp.next = head1 == null ? head2 : head1;
        return pre.next;
    }


    /**
     * 合并 k个 有序链表
     * 方法一：顺序合并，创建一个中间变量 temp，用来接收顺序合并的列表
     * @param lists k个有序链表的集合
     * @return 合并后的链表
     */
    public static ListNode mergeKLists(List<ListNode> lists){

        ListNode result = null;

        for (ListNode list : lists) {
            // 调用 合并两个单链表的方法。
            result = mergeTwoList(list, result);
        }

        return result;
    }

    public static ListNode mergeKLists2(List<ListNode> lists){

        ListNode result = null;

        

        return result;
    }

}
