package tree;

public class DiameterOfBinaryTree {

    static int longest = 0;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(6));

        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        diameterOfBinaryTree.dfs(treeNode);

        System.out.println("longest = " + longest);
    }

    // left, right 의 상태값을 먼저 구해야 한다.
    // 상태값 : 리프노드부터의 거리 -> 리프 to 리프는 0
    public int dfs(TreeNode root) {

        if (root == null) {
            return -1;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        this.longest = Math.max(this.longest, left + right + 2) ;

        return Math.max(left, right) + 1;
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
