package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

    private BinarySearchTree root;

    private void add(BinarySearchTree node){
        if (root == null) {
            root = node;
        }else {
            root.addNode(node);
        }
    }

    /**
     * 非递归中序遍历
     */
    public static void inorderTraversal(BinarySearchTree root){

        Stack<BinarySearchTree> stack = new Stack<>();

        while (root != null || !stack.isEmpty()){
            if (root != null) {
                stack.push(root);
                root = root.left;
            }else {
                // 节点为空
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }


    }


    /**
     * 查找要删除的目标节点
     */

    public static BinarySearchTree searchTarget(int targetValue, BinarySearchTree root){

        if (targetValue == root.val) {
            return root;
        } else if (targetValue < root.val) {
            return root.left == null ? null : searchTarget(targetValue, root.left);
        }else {
            return root.right == null ? null : searchTarget(targetValue, root.right);
        }
    }

    /**
     * 查找目标节点的父节点
     * @param node  目标节点
     * @return 父节点
     */
    public static BinarySearchTree searchNodeParent(BinarySearchTree node, int target){
        // 当前节点就是要删除节点的父节点：
        if ((node.left != null && node.left.val == target) || (node.right != null && node.right.val == target) ){
            return node;
        }
        else{
            // 如果要查找的值小于 当前节点的值 ， 并且当前节点不为空
            if (target < node.val && node.left != null){
                return searchNodeParent(node.left, target);
            } else if(target >= node.val && node.right != null){
                return searchNodeParent(node.right, target);
            } else {
                return null;
            }
        }


    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int data : arr) {
            tree.add(new BinarySearchTree(data));
        }

        inorderTraversal(tree.root);

        BinarySearchTree binarySearchTree = searchTarget(10, tree.root);
        if (binarySearchTree != null) {
            System.out.println(binarySearchTree.val);
        }

    }

    /**
     * 翻转树 递归
     * @param root 根节点
     * @return 根节点
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 从左子树要信息，
        TreeNode leftData = invertTree1(root.left);
        // 从右子树要信息，
        TreeNode rightData = invertTree1(root.right);

        // 左子树变成右边的
        root.left = rightData;
        // 右边的变成左边的
        root.right = leftData;
        return root;

    }

    /**
     * 翻转树  层序遍历
     * @param root 根节点
     * @return 根节点
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode right = node.right;

            // 交换树节点
            node.right = node.left;
            node.left = right;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;

    }

}
