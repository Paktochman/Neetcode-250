// BuildTreePreInorder.java

import java.util.*;

public class BuildTreePreInorder {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private Map<Integer, Integer> indexMap;
    private int preorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        preorderIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int inLeft, int inRight) {
        if (inLeft > inRight) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inorderPos = indexMap.get(rootVal);

        root.left = build(preorder, inLeft, inorderPos - 1);
        root.right = build(preorder, inorderPos + 1, inRight);

        return root;
    }

    // Quick sanity test
    public static void main(String[] args) {
        // preorder = [1,2,3,4]
        // inorder  = [2,1,3,4]
        BuildTreePreInorder b = new BuildTreePreInorder();

        int[] preorder = {1,2,3,4};
        int[] inorder  = {2,1,3,4};

        TreeNode root = b.buildTree(preorder, inorder);
        System.out.println("Root val = " + root.val); // should be 1
    }
}
