package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvertBinaryTree {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(4, new TreeNode(5, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();


        /*TreeNode treeNode1 = invertBinaryTree.invertTree(treeNode);
        System.out.println("treeNode1.right.val = " + treeNode1.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.left.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.left.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.left.left);*/

        /*TreeNode treeNode1 = invertBinaryTree.invertTreeDFS(treeNode);
        System.out.println("treeNode1.right.val = " + treeNode1.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.left.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.left.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.left.left);*/

        TreeNode treeNode1 = invertBinaryTree.invertTreeStackDFS(treeNode);
        System.out.println("treeNode1.right.val = " + treeNode1.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.left.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.left.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.left.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.right.val);
        System.out.println("treeNode1.right.val = " + treeNode1.right.left.left);
    }

    public TreeNode invertTreeStackDFS(TreeNode root) {

        if(root == null)
            return null;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left != null)
                stack.push(node.left);

            if(node.right != null)
                stack.push(node.right);
        }
        return root;
    }

    public TreeNode invertTreeDFS(TreeNode root) {
        if(root == null)
            return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeDFS(root.left);
        invertTreeDFS(root.right);

        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;

        TreeNode newNode = new TreeNode(root.val);
        newNode.left = invertTree(root.right);
        newNode.right = invertTree(root.left);
        return newNode;
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
