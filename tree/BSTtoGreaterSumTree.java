package tree;

public class BSTtoGreaterSumTree {
    public static void main(String[] args) {
        Integer [] nums = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 9};

        TreeNode treeNode = makeBST(nums, 0);
/*        System.out.println("treeNode = " + treeNode.val);
        System.out.println("treeNode = " + treeNode.left.val);
        System.out.println("treeNode = " + treeNode.right.val);
        System.out.println("treeNode = " + treeNode.left.left.val);
        System.out.println("treeNode = " + treeNode.left.right.val);
        System.out.println("treeNode = " + treeNode.right.left.val);
        System.out.println("treeNode = " + treeNode.right.right.val);*/

        TreeNode treeNode1 = bstToGst(treeNode);
        System.out.println("treeNode = " + treeNode1.val);
        System.out.println("treeNode = " + treeNode1.left.val);
        System.out.println("treeNode = " + treeNode1.right.val);
        System.out.println("treeNode = " + treeNode1.left.left.val);
        System.out.println("treeNode = " + treeNode1.left.right.val);
        System.out.println("treeNode = " + treeNode1.right.left.val);
        System.out.println("treeNode = " + treeNode1.right.right.val);

    }

    static int index = 0;
    public static TreeNode makeBST(Integer[] nums, int index) {
        if(nums.length == 0) return null;

        if (index >= nums.length || nums[index] == null) return null;

        TreeNode treeNode = new TreeNode(nums[index]);
        treeNode.left = makeBST(nums, 2 * index + 1);
        treeNode.right = makeBST(nums, 2 * index + 2);

        return treeNode;
    }

    static int val = 0;
    public static TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            val += root.val;
            root.val = val;
            bstToGst(root.left);
        }
        return root;
    }

    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }
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
