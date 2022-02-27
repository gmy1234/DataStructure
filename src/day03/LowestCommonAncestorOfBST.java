package day03;

import tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 二叉树的最低公共祖先
 */
public class LowestCommonAncestorOfBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.val = 0;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        treeNode.left = node1;
        treeNode.right = node2;
        node1.left = new TreeNode(9);
        node1.right = new TreeNode(6);
        node2.left = node3;
        node2.right = node4;

        System.out.println(CommonAncestor(treeNode, node1, node2));
    }

    public static TreeNode CommonAncestor(TreeNode root, TreeNode t1, TreeNode t2){

        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        // 把父节点放进去
        fatherMap.put(root, root);
        // 把每个节点 和父节点放到 map里去
        process(root, fatherMap);
        // 如果有相同的父节

        HashSet<TreeNode> set1 = new HashSet<>();
        TreeNode cur = t1;

        // t1节点从下往上塞进set里
        while (cur != fatherMap.get(cur)) {
            set1.add(cur);
            cur = fatherMap.get(cur);
        }
        set1.add(root);

        // 在遍历 t2 节点，找每个元素的
        TreeNode cur2 = t2;
        while (cur2 != fatherMap.get(cur2)){
            if (set1.contains(cur2)){
                return cur2;
            }
            cur2 = fatherMap.get(cur2);
        }
        return root;
    }

    /**
     * 每个节点的数据放到 map 里
     * Key（该节点） —— Value（该节点的父节点）
     * @param root 根节点
     * @param fatherMap map集合
     */
    public static void process(TreeNode root, HashMap<TreeNode, TreeNode> fatherMap){
        if (root == null) {
            return ;
        }

        // 把每个节点的父节点放进去
        fatherMap.put(root.left, root);
        fatherMap.put(root.right, root);
        process(root.left, fatherMap);
        process(root.right, fatherMap);
    }
}
