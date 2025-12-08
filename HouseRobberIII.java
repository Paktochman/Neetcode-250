// HouseRobberIII.java

public class HouseRobberIII {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // returns {robThis, skipThis}
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // If we rob this node, we cannot rob children
        int rob = node.val + left[1] + right[1];

        // If we skip this node, we can choose to rob or skip children
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};
    }

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    // Quick sanity test
    public static void main(String[] args) {
        /*
            Example:
            root = [1,4,null,2,3,3]
            Expected = 7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);

        HouseRobberIII sol = new HouseRobberIII();
        System.out.println(sol.rob(root)); // expected 7
    }
}
