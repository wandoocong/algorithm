package tree;

public class MergeTwoBinaryTrees {

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1, new TreeNode(4, new TreeNode(5), null), new TreeNode(2));
        TreeNode treeNode2 = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7)));

        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode mergeNode = mergeTwoBinaryTrees.mergeTrees(treeNode1, treeNode2);

        System.out.println("treeNode1.right.val = " + mergeNode.val);
        System.out.println("treeNode1.right.val = " + mergeNode.left.val);
        System.out.println("treeNode1.right.val = " + mergeNode.right.val);
        System.out.println("treeNode1.right.val = " + mergeNode.left.left.val);
        System.out.println("treeNode1.right.val = " + mergeNode.left.right.val);
        System.out.println("treeNode1.right.val = " + mergeNode.right.left);
        System.out.println("treeNode1.right.val = " + mergeNode.right.right.val);

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;

        TreeNode newNode = new TreeNode(root1.val + root2.val);
        newNode.left = mergeTrees(root1.left, root2.left);
        newNode.right = mergeTrees(root1.right, root2.right);
        return newNode;
    }


    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
