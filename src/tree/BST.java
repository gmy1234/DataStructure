package tree;

import java.util.Objects;
import java.util.Stack;

/**
 * @author gmydl
 * @title: Question
 * @projectName DataStructure
 * @description: 试题一
 * @date 2022/6/10 19:26
 */
public class BST {
    /**
     * 实现要求：
     * 1、根据已有的代码片段，创建二叉搜索树；
     * 2、用中序遍历输出排序结果，结果形如：0，1，2 ，3 ，4， 5， 6， 7， 8， 9，
     * 3、使用递归、非递归二种方式实现遍历；
     * 4、注意编写代码注释。
     */

    public static void main(String[] args) {

        final int[] values = {1, 3, 4, 5, 2, 8, 6, 7, 9, 0};

        // 创建一个 BST
        System.out.println("Create BST: ");
        Node root = createBinaryTree(values);

        // 递归方法，实现 BST 的中序遍历
        System.out.println("Traversing the BST with recursive algorithm: ");
        inOrderTransvalWithRecursive(root);
        System.out.println("");

        // 非递归方法，实现 BST 的中序便利
        System.out.println("Traversing the BST with iterative algorithm: ");
        inOrderTransvalWithIterate(root);
    }

    // 构建二叉树
    public static Node createBinaryTree(int[] values) {
        // TODO:
        // 默认以第一个元素为根结点
        Node root = new Node(values[0]);
        // 遍历数组
        for (int i = 1; i < values.length; i++) {
            // 获取要插入节点的值
            int insertValue = values[i];
            // 创建要插入的节点
            Node newNode = new Node(insertValue);
            // 创建一个当前节点
            Node cur = root;
            // 遍历当前节点
            while (Objects.nonNull(cur)) {
                // 插入的节点值 < 当前节点的值
                if (insertValue < cur.getData()) {
                    // 当前节点的左子树为空
                    if (Objects.isNull(cur.getLeftNode())) {
                        // 直接插入节点
                        cur.setLeftNode(newNode);
                        // 跳出 while 循环，执行下一个 for 循环
                        break;
                    }
                    // 当前节点的左子树不为空，继续以左子树为根结点继续比较
                    cur = cur.getLeftNode();
                } else { // 插入的节点值 >= 当前节点
                    // 当前节点的右子节点为空
                    if (Objects.isNull(cur.getRightNode())) {
                        // 直接插入右子节点
                        cur.setRightNode(newNode);
                        // 跳出 while 循环
                        break;
                    }
                    // 当前节点的右子树不为空，继续以右子树为根结点继续比较
                    cur = cur.getRightNode();
                }
            }
        }

        return root;
    }


    // 递归实现
    public static void inOrderTransvalWithRecursive(Node node) {
        // TODO:
        // 根节点校验
        if (Objects.isNull(node)) {
            return;
        }
        // 中序遍历 左 -> 根 -> 右
        // 如果结点的左子节点不为为空
        if (Objects.nonNull(node.getLeftNode())) {
            // 将该左子节点作为结点，递归校验
            inOrderTransvalWithRecursive(node.getLeftNode());
        }
        // 该接点的左子节点为空，输出
        System.out.print(node.getData() + ",");
        // 如果该节点的右子节点不为空
        if (Objects.nonNull(node.getRightNode())) {
            // 将该右子节点作为结点，递归校验
            inOrderTransvalWithRecursive(node.getRightNode());
        }
    }

    // 非递归实现
    public static void inOrderTransvalWithIterate(Node root) {
        // TODO:
        // 使用栈来实现
        Stack<Node> stack = new Stack<>();

        // 当节点不为空 或者 栈不为空的时候
        while (Objects.nonNull(root) || !stack.isEmpty()) {
            // 节点不为空
            if (Objects.nonNull(root)) {
                // 节点入栈
                stack.push(root);
                // 找到下一个左子节点
                root = root.getLeftNode();
            }else { // 节点为空
                // 弹出栈顶元素
                root = stack.pop();
                System.out.print(root.getData() + ",");
                // 寻找下一个右子节点
                root = root.getRightNode();
            }
        }
    }



}
