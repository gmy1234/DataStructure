package tree;

import java.util.*;

public class foreach {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        treeNode.val = 0;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        treeNode.left = node1;
        treeNode.right = node2;
        node2.left = node3;
        node2.right = node4;

        System.out.println(isBST(treeNode));

        double a = -Double.MAX_VALUE;
        System.out.println();
        System.out.println("-------------");
    }

    public static void stackPreOrder(TreeNode head) {

        if (head == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            System.out.print(node.val+ " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
    }


    public static List<Integer> stackinorder(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();

        while (head != null || !stk.isEmpty()) {
            while (head != null) {
                stk.push(head);
                head = head.left;
            }

            head = stk.pop();
            result.add(head.val);
            head = head.right;
        }

        return result;
    }


    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    public static void  preorder(TreeNode root, int target){
        // 递归
        int count = Integer.MIN_VALUE;
        if (target == root.val){
            System.out.print("target:" + root.val );
        }

        if (root.left != null) {
           preorder(root.left, target);
        }
        if (root.right != null) {
            preorder(root.right, target);
        }

    }

    public static void inorder(TreeNode root){
        if (root.left != null){
            inorder(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            inorder(root.right);
        }
    }

    public static void postorder(TreeNode root){
        if (root.left != null){
            postorder(root.left);
        }
        if (root.right != null) {
            postorder(root.right);
        }
        System.out.print(root.val + " ");
    }


    /**
     * 非递归先序遍历
     */
    public static void preorderTree(TreeNode node){

        // 创建栈
        Stack<TreeNode> stack = new Stack<>();

        // 根元素 入栈
        stack.push(node);
        // 循环
        while (!stack.isEmpty()){
            // 弹出栈顶元素
            node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }

    }


    /**
     * 非递归中序遍历
     */
    public static void inorderTree(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                // 处理
                System.out.print(root.val + " ");
                root = root.right;
            }
        }

    }

    /**
     * 非递归后序遍历
     */
    public static void postorderTree(TreeNode root){
//        中左右
//        中右左
//        左右中
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            temp.push(node);

            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        while (!temp.isEmpty()) {
            System.out.print(temp.pop().val + " ");
        }

    }

    /**
     * 判断是否是完全二叉树
     */
    public static boolean isCBT(TreeNode head){
        // 层序遍历用队列

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        // 表示有右孩子无左孩子的事件
        boolean hasRightNotLeft = false;
        TreeNode left = null;
        TreeNode right = null;

        while (!queue.isEmpty()){
            head = queue.pop();

            left = head.left;
            right = head.right;

            if (
                    // 表示遇到了不双全的节点之后 && 又发现当前节点居然有孩子
                    (hasRightNotLeft && (left != null || right !=null))
                    ||
                            // 有右无左
                    (left == null && right != null)
            ){
                return false;
            }


            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
            // 左右节点不双全 就为true
            if (left == null || right == null) {
                hasRightNotLeft = true;
            }

        }
        return true;
    }


    /**
     * 判断是否是二叉搜索树
     */
    public static boolean isBST(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        int preNodeValue = Integer.MIN_VALUE;
        while (!stack.isEmpty() || node != null) {

            if (node != null) {
                stack.push(node);
                node = node.left;
            }else {
                node = stack.pop();
                if (node.val < preNodeValue){
                    return false;
                }
                preNodeValue = node.val;
                node = node.right;
            }
        }
        return true;
    }
}
