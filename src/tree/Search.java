package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 0;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        treeNode.left = node1;
        node1.left = new TreeNode(0);
        node1.right = new TreeNode(-4);
        treeNode.right = node2;
        node2.left = node3;
        node2.right = node4;

        traversal(treeNode);

    }

    public static void width(TreeNode root){

        if (root == null) {
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }


    }


    public static List<List<Integer>> traversal (TreeNode root) {

        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result =  new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int count = queue.size();
            List<Integer> data =  new ArrayList<>();

            while (count > 0) {
                TreeNode cur = queue.pop();
                data.add(cur.val);

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                count --;
            }
            result.add(data);
        }
        return result;
    }
}
