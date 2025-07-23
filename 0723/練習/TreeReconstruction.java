import java.util.*;

public class TreeReconstruction {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPreIn(preorder, 0, preorder.length - 1,
                          inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPreIn(int[] pre, int preStart, int preEnd,
                                       int[] in, int inStart, int inEnd,
                                       Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPreIn(pre, preStart + 1, preStart + leftSize,
                               in, inStart, inRoot - 1, inMap);
        root.right = buildPreIn(pre, preStart + leftSize + 1, preEnd,
                                in, inRoot + 1, inEnd, inMap);
        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = buildIndexMap(inorder);
        return buildPostIn(postorder, 0, postorder.length - 1,
                           inorder, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildPostIn(int[] post, int postStart, int postEnd,
                                        int[] in, int inStart, int inEnd,
                                        Map<Integer, Integer> inMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = post[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int inRoot = inMap.get(rootVal);
        int leftSize = inRoot - inStart;

        root.left = buildPostIn(post, postStart, postStart + leftSize - 1,
                                in, inStart, inRoot - 1, inMap);
        root.right = buildPostIn(post, postStart + leftSize, postEnd - 1,
                                 in, inRoot + 1, inEnd, inMap);
        return root;
    }

    public static void printInorder(TreeNode node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    public static void printPreorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }

    public static void printPostorder(TreeNode node) {
        if (node == null) return;
        printPostorder(node.left);
        printPostorder(node.right);
        System.out.print(node.val + " ");
    }

    private static Map<Integer, Integer> buildIndexMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root1 = buildFromPreIn(preorder, inorder);
        System.out.println("從前序+中序重建的樹:");
        System.out.print("中序: "); printInorder(root1); System.out.println();
        System.out.print("前序: "); printPreorder(root1); System.out.println();
        System.out.print("後序: "); printPostorder(root1); System.out.println();

        TreeNode root2 = buildFromPostIn(postorder, inorder);
        System.out.println("\n從後序+中序重建的樹:");
        System.out.print("中序: "); printInorder(root2); System.out.println();
        System.out.print("前序: "); printPreorder(root2); System.out.println();
        System.out.print("後序: "); printPostorder(root2); System.out.println();
    }
}
