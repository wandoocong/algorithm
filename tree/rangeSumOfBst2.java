package tree;

public class rangeSumOfBst2 {
    public static void main(String[] args) {
        Integer arr[] = {10, 5, 15, 3, 6, null, 18};
        int index = 0;
        TreeNode root = makeBST(arr, index);

        int answer = rangeSumBst(root, 6, 15);
        System.out.println("answer = " + answer);
    }

    public static int rangeSumBst(TreeNode root, int low, int high) {

        if(root == null) return 0;

        if (root.val > high) {
            return rangeSumBst(root.left, low, high);
        }

        if (root.val < low) {
            return rangeSumBst(root.right, low, high);
        }
        //여기까지 도달했다면 노드값이 low, high 범위에 있으므로, 모든결과 합산하여 리턴
        return root.val + rangeSumBst(root.left, low, high) + rangeSumBst(root.right, low, high);
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

