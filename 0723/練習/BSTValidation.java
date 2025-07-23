import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) return false;
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }

    public static List<TreeNode> findViolatingNodes(TreeNode root) {
        List<TreeNode> violations = new ArrayList<>();
        findViolationsInOrder(root, new TreeNode[]{null}, violations);
        return violations;
    }

    private static void findViolationsInOrder(TreeNode node, TreeNode[] prev, List<TreeNode> violations) {
        if (node == null) return;
        findViolationsInOrder(node.left, prev, violations);
        if (prev[0] != null && node.data <= prev[0].data) {
            violations.add(node);
        }
        prev[0] = node;
        findViolationsInOrder(node.right, prev, violations);
    }

    public static int minRemovalsToBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        getInOrder(root, inorder);
        int lisLength = longestIncreasingSubsequence(inorder);
        return inorder.size() - lisLength;
    }

    private static void getInOrder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        getInOrder(node.left, list);
        list.add(node.data);
        getInOrder(node.right, list);
    }

    private static int longestIncreasingSubsequence(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(dp, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == dp.size()) {
                dp.add(num);
            } else {
                dp.set(idx, num);
            }
        }
        return dp.size();
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(12);

        System.out.println("是否為合法 BST: " + isValidBST(root));

        List<TreeNode> badNodes = findViolatingNodes(root);
        System.out.print("違規節點: ");
        for (TreeNode n : badNodes) {
            System.out.print(n.data + " ");
        }
        System.out.println();

        System.out.println("最少移除節點數: " + minRemovalsToBST(root));
    }
}
