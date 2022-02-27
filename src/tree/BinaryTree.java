package tree;

public class BinaryTree {
    private Node rootNode;

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }

    /**
     *     前序遍历
      */
    public void preOrder(){
        if (this.rootNode != null){
            this.rootNode.preOrderTraversal();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     *     中序遍历
     */
    public void inOrder(){
        if (this.rootNode != null){
            this.rootNode.inOrderTraversal();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     *     后序遍历
     */
    public void postOrder(){
        if (this.rootNode != null){
            this.rootNode.postOrderTraversal();
        }else {
            System.out.println("二叉树为空，无法遍历");
        }
    }
}
