public class TreeComparison {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) return true;
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static int largestCommonSubtree(TreeNode s, TreeNode t) {

        if (s == null || t == null) return 0;
        int maxSize = 0;
        if (isSameTree(s, t)) {
            maxSize = countNodes(s);
        }
        int leftMax = largestCommonSubtree(s.left, t);
        int rightMax = largestCommonSubtree(s.right, t);
        int tLeftMax = largestCommonSubtree(s, t.left);
        int tRightMax = largestCommonSubtree(s, t.right);

        return Math.max(maxSize, Math.max(Math.max(leftMax, rightMax), Math.max(tLeftMax, tRightMax)));
    }

    private static int countNodes(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {

        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println("s 和 t 是否完全相同: " + isSameTree(s, t));

        System.out.println("t 是否為 s 的子樹: " + isSubtree(s, t));

        int maxCommon = largestCommonSubtree(s, t);
        System.out.println("最大公共子樹節點數: " + maxCommon);
    }
}
