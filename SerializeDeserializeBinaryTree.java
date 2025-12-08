// SerializeDeserializeBinaryTree.java

import java.util.*;

public class SerializeDeserializeBinaryTree {

    // Standard TreeNode used by LeetCode problems
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) { this.val = val; }
    }

    // Codec for serialization and deserialization
    public static class Codec {

        // Encodes a tree to a single string.
        // Uses preorder traversal with 'null' markers separated by commas.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            preorderSerialize(root, sb);
            // remove final comma if needed (not necessary but cleaner)
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.setLength(sb.length() - 1);
            }
            return sb.toString();
        }

        private void preorderSerialize(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null").append(',');
                return;
            }
            sb.append(node.val).append(',');
            preorderSerialize(node.left, sb);
            preorderSerialize(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;
            // split into tokens and use a queue/list for sequential consumption
            String[] tokens = data.split(",");
            LinkedList<String> q = new LinkedList<>(Arrays.asList(tokens));
            return buildTree(q);
        }

        private TreeNode buildTree(LinkedList<String> q) {
            if (q.isEmpty()) return null;
            String token = q.removeFirst();
            if ("null".equals(token)) return null;
            TreeNode node = new TreeNode(Integer.parseInt(token));
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }

    // Quick sanity test (optional)
    public static void main(String[] args) {
        // Build sample tree: [1,2,3,null,null,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String ser = codec.serialize(root);
        System.out.println("Serialized: " + ser);

        TreeNode des = codec.deserialize(ser);
        String ser2 = codec.serialize(des);
        System.out.println("Re-serialized after deserialize: " + ser2);

        // They should be equal
        System.out.println("Matches: " + ser.equals(ser2));
    }
}
