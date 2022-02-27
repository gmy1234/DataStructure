package tree;

public class Node {
    private int data;

    private Node leftNode;
    private Node rightNode;

    public Node(int data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node  getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node  leftNode) {
        this.leftNode = leftNode;
    }

    public Node  getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "data=" + data +
                '}';
    }

    /**
     * 前序遍历的方法
     * 中 左 右
     */

    public void preOrderTraversal(){
        // 先输出父节点
        System.out.println(this);
        // 判断是否有 左子节点：
        if (this.leftNode != null) {
           this.leftNode.preOrderTraversal();
        }
        if (this.rightNode != null){
            // 再输出 右子节点
            this.rightNode.preOrderTraversal();
        }
    }

    /**
     * 中序遍历
     */

    public void inOrderTraversal(){
        if (this.leftNode != null){
            this.leftNode.inOrderTraversal();
        }
        System.out.println(this);
        if (this.rightNode != null){
            // 再输出 右子节点
            this.rightNode.inOrderTraversal();
        }
    }

    /**
     * 后序遍历
     */

    public void postOrderTraversal(){
        if (this.leftNode != null){
            this.leftNode.postOrderTraversal();
        }
        if (this.rightNode != null){
            // 再输出 右子节点
            this.rightNode.postOrderTraversal();
        }
        System.out.println(this);

    }
}
