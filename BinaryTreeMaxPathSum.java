// BinaryTreeMaxPathSum.java

public class BinaryTreeMaxPathSum {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int globalMax;

    public int maxPathSum(TreeNode root) {
        globalMax = Integer.MIN_VALUE;
        dfs(root);
        return globalMax;
    }

    // returns max gain from this node going upward
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // Path through this node including both children
        int fullPath = node.val + leftGain + rightGain;

        // Update global best
        globalMax = Math.max(globalMax, fullPath);

        // Return best single-branch gain
        return node.val + Math.max(leftGain, rightGain);
    }

    // Quick test
    public static void main(String[] args) {
        /*
            Input: [1,2,3]
            Output: 6
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BinaryTreeMaxPathSum sol = new BinaryTreeMaxPathSum();
        System.out.println(sol.maxPathSum(root)); // 6
    }
}
