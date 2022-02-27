package tree;


public class Recursion {
    public static class returnType{
        boolean isBST;
        int max;
        int min;

        public returnType(boolean isB , int ma, int mi) {
            isBST = isB;
            max = ma;
            min = mi;
        }
    }

    /**
     *  递归判断是否是二×排序树
     * @param node 根节点
     * @return returnType
     */
    public static returnType process(TreeNode node){

        if (node == null) {
            return null;
        }

        returnType leftData = process(node.left);
        returnType rightData = process(node.right);

        int min = node.val;
        int max = node.val;

        if (leftData != null){
            min = Math.min(leftData.min, min);
            max = Math.max(leftData.max, max);
        }
        if (rightData != null) {
            min = Math.min(rightData.min, min);
            max = Math.max(rightData.max, max);
        }

        boolean isBST = true;
        /* 左边不为空 且 左边的最大值 > 根节点的值  ||  左边不为空 且 左边不是二叉搜索树，*/
        if (leftData != null && (!leftData.isBST || leftData.max >= node.val)){
            isBST = false;
        }
        if (rightData != null && (!rightData.isBST || rightData.min <= node.val)){
            isBST = false;
        }

        return new returnType(isBST, max, min);
    }


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


        System.out.println(isBT(treeNode).isBalanceTree);

    }

    public static class Info{
        // 节点高度
        int nodeHeight;
        // 节点数量
        int nodeCount;

        public Info(int nodeHeight, int nodeCount) {
            this.nodeHeight = nodeHeight;
            this.nodeCount = nodeCount;
        }
    }

    /**
     *  递归判断是否满是满二叉树
     */
    public static boolean isFST(TreeNode node){
        if (node == null) {
            return true;
        }
        Info data = d(node);
        return data.nodeCount == ((1 << data.nodeHeight) - 1);
    }

    public static Info d(TreeNode node){
        if (node == null) {
            return new Info(0,0);
        }
        Info leftData = d(node.left);
        Info rightData = d(node.right);

        int height = Math.max(leftData.nodeHeight, rightData.nodeHeight) + 1;
        int count = leftData.nodeCount + rightData.nodeCount + 1;

        return new Info(height, count);
    }


    public static class BalanceInfo{
        int height;
        boolean isBalanceTree;

        public BalanceInfo() {
        }

        public BalanceInfo(int height, boolean isBalanceTree) {
            this.height = height;
            this.isBalanceTree = isBalanceTree;
        }
    }


    public static BalanceInfo isBT(TreeNode node){
        if (node == null) {
            return new BalanceInfo(0, true);
        }

        BalanceInfo leftData = isBT(node.left);
        BalanceInfo rightData = isBT(node.right);

        int height = Math.max(leftData.height, rightData.height) + 1;

        // 左右的树高度差
        boolean  heightDifference = Math.abs(leftData.height - rightData.height) < 2;
        // 左右树是否都为平衡的二叉树
        boolean isBalance = (leftData.isBalanceTree && rightData.isBalanceTree) && heightDifference ;

        return new BalanceInfo(height, isBalance);

    }
}
