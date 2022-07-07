package listnode;

import java.util.HashSet;
import java.util.Stack;

public class 单链表 {

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
        t5.next = null;

        ListNode q3 = new ListNode(1);
        ListNode q4 = new ListNode(2);
        ListNode q5 = new ListNode(1);
        q3.next = q4;
        q4.next = q5;


        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a5.next = a3;
        a3.next = a4;


        ListNode node = rotateRight(t1,2);
        System.out.println(node);


    }

    /**
     * 翻转单链表
     *
     * @param t1 链表
     * @ListNode 链表
     */
    public static ListNode reverseList1(ListNode t1) {

        ListNode pre = null;
        ListNode cur = t1;
        ListNode next = t1.next;

        while (cur != null) {
            cur.next = pre;

            pre = cur;
            cur = next;
            if (next != null) {
                next = next.next;
            }
        }
        return pre;
    }

    /**
     * 删除单链表
     *
     * @param t 链表
     * @ListNode 链表
     */
    public static ListNode deleteNode(ListNode t, int val) {
        if(t == null){
            return t;
        }
        if(t.val == val){
            return t.next;
        }

        ListNode pre = t;
        ListNode cur = pre.next;

        while (cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur != null) {
            pre.next = cur.next;
        }
        return t;

    }

    /**
     * 删除单链表倒数第k个节点
     *
     * @param head 头结点
     * @param n    倒数第k个
     * @return 新的链表
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }

        ListNode pre = null;
        while (fast != null) {
            fast = fast.next;
            // 用来记录慢指针前边的一个节点
            pre = slow;
            slow = slow.next;
        }

        // slow 就是被删除的节点
        if (pre != null) {
            pre.next = pre.next.next;
            return head;
        } else {
            pre = slow.next;
            slow.next = null;
            return pre;
        }

    }


    /**
     * 倒数第k个节点的单链表 栈
     *
     * @param head 链表
     * @param k    节点
     * @return 链表
     */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        int count = 0;
        ListNode res = null;
        while (!stack.isEmpty() && count != k) {
            res = stack.pop();
            count++;
        }
        return res;

    }

    /**
     * 倒数第k个节点的单链表  快慢指针
     *
     * @param head 链表
     * @param k    节点
     * @return 链表
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = null;
        ListNode cur = head;
        while (k > 0 && cur != null) {
            k--;
            cur = cur.next;
        }
        // 快指针 指向 第k + 1个节点
        fast = cur;
        // 慢指针，指向头部
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    /**
     * 合并两个有序的单链表
     *
     * @param list1 链表,
     * @param list2 链表,
     * @ListNode 结果
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode pre = new ListNode(-1);
        // 取头结点
        pre.next = list1.val > list2.val ? list2 : list1;
        ListNode result = pre;
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 == null && list2 != null) {
            pre.next = list2;
        } else if (list1 != null && list2 == null) {
            pre.next = list1;
        }

        return result.next;
    }

    /**
     * 全部压入栈
     *
     * @param t1 链表
     * @return 是否
     */
    public static boolean isPalindromeList1(ListNode t1) {
        ListNode cur = t1;
        Stack<ListNode> stack = new Stack<>();

        // 依次压入栈
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (t1 != null) {
            ListNode popNode = stack.pop();

            // 和比较 t1 比较
            if (t1.val != popNode.val) {
                return false;
            }
            t1 = t1.next;
        }
        return true;
    }

    /**
     * 快慢指针的方法 一半压入栈
     *
     * @param t1
     * @return
     */
    public static boolean isPalindromeList2(ListNode t1) {
        // 快指针
        ListNode fast = t1;
        // 慢指针
        ListNode cur = t1.next;

        while (fast.next != null && fast.next.next != null) {
            cur = cur.next;
            fast = fast.next.next;
        }

        // 慢指针之后的  都压入栈
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {
            ListNode popNode = stack.pop();
            if (popNode.val != t1.val) {
                return false;
            }
            t1 = t1.next;
        }
        return true;
    }


    /**
     * 判断单链表是否有环
     *
     * @param head
     * @return
     */
    public static boolean linkedListCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static boolean linkedListCycle1(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();

        while (head != null) {
            boolean add = hashSet.add(head);
            if (!add) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public static ListNode linkedListCycleII(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int flag = 0;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 是个环 跳出来
            if (slow == fast) {
                flag = 1;
                break;
            }
        }
        if (flag == 0) {
            return null;
        }

        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }


    /**
     * 相交链表
     *
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交的节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int aCount = 1;
        int bCount = 1;

        ListNode curA = headA;
        ListNode curB = headB;

        while (curA.next != null) {
            aCount++;
            curA = curA.next;
        }
        while (curB.next != null) {
            bCount++;
            curB = curB.next;
        }

        // 判断A和B是否 相交
        if (curA != curB) {
            return null;
        }

        // 相交
        // 设置长链表
        ListNode longList = headA;
        ListNode shortList = headB;
        if (aCount < bCount) {
            longList = headB;
            shortList = headA;
        }
        // 长链表先走 差值长度

        int gap = Math.abs(aCount - bCount);
        while (gap > 0) {
            assert longList != null;
            longList = longList.next;
            gap--;
        }

        while (longList != null) {
            if (longList == shortList) {
                return longList;
            }
            longList = longList.next;
            assert shortList != null;
            shortList = shortList.next;
        }

        return null;
    }

    /**
     * 链表相邻节点的交换
     *
     * @param head 头结点
     * @return 交换后的节点
     */
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dy = new ListNode(0, head);
        ListNode pre = dy;
        ListNode left = head;
        ListNode right = head.next;
//        ListNode next;

        while (left != null && right != null) {

            swapNode(pre, left, right);
//            /* 翻转left 和right */
//            pre.next = left.next;
//            next = right.next;
//            right.next = left;
//            left.next = next;

            pre = pre.next.next;
            left = right.next.next;
            if (left != null) {
                right = left.next;
            }

        }

        return dy.next;
    }

    /**
     * 交换 链表两个相邻的节点
     * @param pre 节点1的前一个
     * @param node1 节点1
     * @param node2 节点2
     */
    public static void swapNode(ListNode pre, ListNode node1, ListNode node2) {
        ListNode next;

        /* 翻转left 和right */
        pre.next = node1.next;
        next = node2.next;
        node2.next = node1;
        node1.next = next;
    }


    /**
     * 链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * @param head 头结点
     * @param k 移动的次数
     */
    public static ListNode rotateRight(ListNode head, int k) {

        ListNode cur = head;
        ListNode rear = null;
        int lenght = 1;
        while (cur.next != null) {
            cur = cur.next;
            rear = cur;
            lenght++;
        }
        // 先遍历求得链表总长度count，同时将链表首尾相连；
        // 再找到原链表的倒数第k+1个节点，该节点的next就是新链表的头结点。
        rear.next = head;
        int postion = lenght - (k % lenght);

        while (postion > 1) {
            head = head.next;
            postion--;
        }

        ListNode result = head.next;
        head.next = null;
        return result;
    }




}
