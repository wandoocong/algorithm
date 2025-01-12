package tree;

public class rangeSumOfBst {
    public static void main(String[] args) {
        Integer arr[] = {10, 5, 15, 3, 6, null, 18};
        int index = 0;
        TreeNode root = makeBST(arr, index);

        int answer = rangeSumBst(root, 6, 15);
        System.out.println("answer = " + answer);
    }

    public static int rangeSumBst(TreeNode root, int low, int high) {

        if(root == null) return 0;

        int result = 0;
        if (low <= root.val && root.val <= high) {
            result += root.val;
        }
        result += rangeSumBst(root.left, low, high);
        result += rangeSumBst(root.right, low, high);

        return result;
    }

    private static TreeNode makeBST(Integer [] arr, int index) {
        if(arr.length == 0) return null;

        if (index >= arr.length || arr[index] == null) return null;

        TreeNode treeNode = new TreeNode(arr[index]);
        treeNode.left = makeBST(arr, index * 2 + 1);
        treeNode.right = makeBST(arr, index * 2 + 2);

        return treeNode;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

