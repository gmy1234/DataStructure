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
        // ??????
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
     * ?????????????????????
     */
    public static void preorderTree(TreeNode node){

        // ?????????
        Stack<TreeNode> stack = new Stack<>();

        // ????????? ??????
        stack.push(node);
        // ??????
        while (!stack.isEmpty()){
            // ??????????????????
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
     * ?????????????????????
     */
    public static void inorderTree(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                // ??????
                System.out.print(root.val + " ");
                root = root.right;
            }
        }

    }

    /**
     * ?????????????????????
     */
    public static void postorderTree(TreeNode root){
//        ?????????
//        ?????????
//        ?????????
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
     * ??????????????????????????????
     */
    public static boolean isCBT(TreeNode head){
        // ?????????????????????

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(head);

        // ???????????????????????????????????????
        boolean hasRightNotLeft = false;
        TreeNode left = null;
        TreeNode right = null;

        while (!queue.isEmpty()){
            head = queue.pop();

            left = head.left;
            right = head.right;

            if (
                    // ??????????????????????????????????????? && ????????????????????????????????????
                    (hasRightNotLeft && (left != null || right !=null))
                    ||
                            // ????????????
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
            // ????????????????????? ??????true
            if (left == null || right == null) {
                hasRightNotLeft = true;
            }

        }
        return true;
    }


    /**
     * ??????????????????????????????
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
