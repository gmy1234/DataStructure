package tree;

public class BinarySearchTree {
    int val;
    BinarySearchTree left;
    BinarySearchTree right;

    BinarySearchTree() {

    }

    BinarySearchTree(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    BinarySearchTree(int val, BinarySearchTree left, BinarySearchTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public void addNode(BinarySearchTree node){
        if (node == null) {
            return;
        }
        // 添加节点
        // 添加左子节点 和当前根节点进行比较
        if (node.val < this.val){
            // 判断当前根节点的左子节点 是否为空
            if (this.left == null) {
                this.left = node;
            } else
                // 不为空，递归向左子树添加
            {
                this.left.addNode(node);
            }

        } else { // 当前节点 >= 该节点的值
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.addNode(node);
            }

        }
    }




    public static void main(String[] args) {



    }
}
