// DeleteLeavesWithTarget.java

public class DeleteLeavesWithTarget {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        // After pruning children, check if current becomes a leaf with target
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }

    // Quick test
    public static void main(String[] args) {
        /*
            Input: root = [1,2,3,5,2,2,5], target = 2
            Output: [1,2,3,5,null,null,5]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(5);

        DeleteLeavesWithTarget sol = new DeleteLeavesWithTarget();
        TreeNode res = sol.removeLeafNodes(root, 2);

        System.out.println("Root after deletion: " + (res == null ? "null" : res.val));
    }
}
