package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(10, new TreeNode(15), new TreeNode(7)));

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();

        int i = maximumDepthOfBinaryTree.maxDepth(treeNode);
        int recursiveDepth = maximumDepthOfBinaryTree.recursiveMaxDepth(treeNode);

        System.out.println("depth = " + i);
        System.out.println("recursiveDepth = " + recursiveDepth);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while(!queue.isEmpty()) {
            depth += 1;
            int q_size = queue.size();

            for (int i = 0; i < q_size; i++) {
                // 해당 깊이의 모든 노드 수만큼 반복
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return depth;
    }

    public int recursiveMaxDepth(TreeNode root) {

        // null 이면 0을 return
        // 리프노드에 left, right 는 null 이므로 각각 0을 return
        // 따라서 리프노드의 높이는 1(Math.max(0,0)+1)이 됨
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        // 리프노드 같은경우 left, right 값이 0, 0 이므로 1이됨
        return Math.max(left, right) + 1;
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
