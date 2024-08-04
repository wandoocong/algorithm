package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));

        Serialize serialize = new Serialize();
        String serializeStr = serialize.serialize(treeNode);
        System.out.println("serializeStr = " + serializeStr);

        TreeNode deserialize = serialize.deserialize(serializeStr);
        System.out.println("treeNode1.right.val = " + deserialize.val);
        System.out.println("treeNode1.right.val = " + deserialize.left.val);
        System.out.println("treeNode1.right.val = " + deserialize.right.val);
        System.out.println("treeNode1.right.val = " + deserialize.left.left.val);
        System.out.println("treeNode1.right.val = " + deserialize.right.right.val);
    }

    public String serialize(TreeNode root) {

        if(root ==null) return "";

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf("#," + root.val));

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
                sb.append("," + node.left.val);
            }else{
                sb.append(",#");
            }
            if (node.right != null) {
                queue.add(node.right);
                sb.append("," +  + node.right.val);
            }else{
                sb.append(",#");
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(nodes[1]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 2;

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!nodes[index].equals("#")) {
                node.left = new TreeNode(Integer.valueOf(nodes[index]));
                queue.add(node.left);
            }
            index++;

            if (!nodes[index].equals("#")) {
                node.right = new TreeNode(Integer.valueOf(nodes[index]));
                queue.add(node.right);
            }
            index++;
        }
        return root;
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
