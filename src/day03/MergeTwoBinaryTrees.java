package day03;



import tree.TreeNode;

import java.util.Stack;

public class MergeTwoBinaryTrees {
    public static void main(String[] args) {

        TreeNode resultTree = new TreeNode();

        TreeNode r1 = new TreeNode();
        TreeNode r2 = new TreeNode();

        // 深度优先
    }

    public static void preorder (TreeNode node){
        Stack<TreeNode> stack = new Stack<>();

        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }
}
