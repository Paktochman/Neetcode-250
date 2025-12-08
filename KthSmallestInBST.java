// KthSmallestInBST.java

import java.util.*;

public class KthSmallestInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Push all left nodes
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Pop smallest available
            curr = stack.pop();
            k--;
            if (k == 0) return curr.val;

            // Go to right subtree
            curr = curr.right;
        }

        return -1; // should never hit due to constraints
    }

    // Optional quick sanity test
    public static void main(String[] args) {
        /*
            Tree:
              2
             / \
            1   3
            k = 1 => output = 1
        */
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        KthSmallestInBST sol = new KthSmallestInBST();
        System.out.println(sol.kthSmallest(root, 1)); // expected 1
    }
}
