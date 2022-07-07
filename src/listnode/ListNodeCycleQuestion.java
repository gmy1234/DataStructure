package listnode;

/**
 * 单链表的环问题
 */
public class ListNodeCycleQuestion {
    public static void main(String[] args) {

    }

    /**
     * 获取单链表的入环节点
     * @param head 单链表的头
     * @return 入环节点
     */
    public static ListNode getLoopNode(ListNode head){

        ListNode fast = head;
        ListNode slow = head;
        int flag = 0;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                flag = 1;
                break;
            }
        }
        if (flag == 0){
            return null;
        }
        // 头节点赋给将快指针
        // 从新遍历,每次走一步，相交节点入环
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 无环 单链表相交问题
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交的节点
     */
    public static ListNode noLoop(ListNode headA, ListNode headB){

        ListNode a = headA;
        ListNode b = headB;
        int countA = 0;
        int countB = 0;
        while (a != null) {
            countA ++;
            a = a.next;
        }
        while (b != null) {
            countB ++;
            b = b.next;
        }
        // 定义长链表和短链表
        ListNode longList = headA;
        ListNode shortList = headB;
        if (countA < countB) {
            longList = headB;
            shortList = headA;
        }

        int gap = Math.abs(countA -countB);
        while (gap > 0) {
            gap--;
            longList = longList.next;
        }
        while (shortList != null) {

            if (longList == shortList){
                return longList;
            }
            shortList = shortList.next;
            longList = longList.next;
        }
        return null;
    }

    /**
     *  两条单链表都有环的情况
     *      2.相交但是入环节点是同一个
     *      3.相交但是入环节点 不是用一个。
     * @param headA 链表A
     * @param loopA 链表A 的入环节点
     * @param headB 链表B
     * @param loopB 链表B 的入环节点
     * @return 返回两个链表相交的节点
     */
    public static ListNode bothLoop(ListNode headA, ListNode loopA, ListNode headB, ListNode loopB){
        if (loopA == loopB){
            // 入环节点是相同的。
            ListNode curA = headA;
            ListNode curB = headB;

            // 都遍历到入环节点就停下，然后直接.
            int countA = 0;
            int countB = 0;
            while (curA != loopA) {
                countA ++;
                curA = curA.next;
            }
            while (curB != loopB) {
                countB ++;
                curB = curB.next;
            }
            ListNode longList = headA;
            ListNode shortList = headB;

            if (countA < countB) {
                longList = headB;
                shortList = headA;
            }
            // 长链表先走 差值步
            int gap = Math.abs( countA - countB);
            while (gap > 0) {
                longList = longList.next;
            }
            // 一起走
            while (longList != shortList) {
                longList = longList.next;
                shortList = shortList.next;
            }
            return longList;
        }else {
            // 入环节点不同：
            ListNode curA = loopA.next;
            // 遍历入环节点A
            while (curA != loopA){
                // 在入环节点A遍历的过程中，遇到了入环节点loopB ，直接返回
                // 这种情况 有两个入环节点，
                if (curA == loopB) {
                    return curA;
                }
                curA = curA.next;
            }
            return null;
        }
    }

    /**
     * 相交链表
     * @param headA 链表A
     * @param headB 链表B
     * @return 相交链表的相交节点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode loopA = getLoopNode(headA);
        ListNode loopB = getLoopNode(headB);

        if (loopA == null && loopB == null) {
            return noLoop(headA, headB);
        }
        if (loopA != null && loopB != null) {
            return bothLoop( headA,  loopA,  headB,  loopB);
        }
        return null;
    }



}
