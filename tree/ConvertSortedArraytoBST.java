package tree;

public class ConvertSortedArraytoBST {

    public static void main(String[] args) {
        int[] nums = {-10, -7, -3, 0, 5, 7, 9};

        if(nums.length == 0)
            return;

        TreeNode construct = construct(nums, 0, nums.length - 1);
        System.out.println("construct = " + construct.val);
        System.out.println("construct = " + construct.left.val);
        System.out.println("construct = " + construct.right.val);
    }

    public static TreeNode construct(int[] nums, int lo, int hi) {

        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;

        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = construct(nums, lo, mid - 1);
        treeNode.right = construct(nums, mid + 1, hi);
        return treeNode;
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


