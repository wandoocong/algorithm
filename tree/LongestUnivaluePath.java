package tree;

public class LongestUnivaluePath {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(1)), new TreeNode(3, null, new TreeNode(3)));

        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        longestUnivaluePath.dfs(treeNode);
        System.out.println("result = " + result);
    }
    static int result;
    public int dfs(TreeNode node) {

        if(node==null)
            return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        if(node.left != null && node.left.val ==node.val)
            left++;
        else
            left = 0;

        if(node.right != null && node.right.val ==node.val)
            right++;
        else
            right = 0;

        this.result = Math.max(this.result, left + right);
        return Math.max(left, right);
    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
