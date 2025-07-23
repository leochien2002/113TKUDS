public class BSTBalance {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class BalanceInfo {
        int height;
        boolean balanced;
        int balanceFactor;

        BalanceInfo(int height, boolean balanced, int balanceFactor) {
            this.height = height;
            this.balanced = balanced;
            this.balanceFactor = balanceFactor;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkBalance(root).balanced;
    }

    private static BalanceInfo checkBalance(TreeNode node) {
        if (node == null) {
            return new BalanceInfo(0, true, 0);
        }

        BalanceInfo leftInfo = checkBalance(node.left);
        BalanceInfo rightInfo = checkBalance(node.right);

        int height = 1 + Math.max(leftInfo.height, rightInfo.height);
        int balanceFactor = leftInfo.height - rightInfo.height;
        boolean balanced = leftInfo.balanced && rightInfo.balanced && Math.abs(balanceFactor) <= 1;

        return new BalanceInfo(height, balanced, balanceFactor);
    }

    static class UnbalancedNode {
        TreeNode node = null;
        int maxAbsBalance = -1;
        int balanceFactor = 0;
    }

    public static TreeNode findMostUnbalancedNode(TreeNode root) {
        UnbalancedNode res = new UnbalancedNode();
        findUnbalanced(root, res);
        return res.node;
    }

    private static int findUnbalanced(TreeNode node, UnbalancedNode res) {
        if (node == null) return 0;

        int leftHeight = findUnbalanced(node.left, res);
        int rightHeight = findUnbalanced(node.right, res);
        int bf = leftHeight - rightHeight;

        int absBf = Math.abs(bf);
        if (absBf > res.maxAbsBalance) {
            res.maxAbsBalance = absBf;
            res.node = node;
            res.balanceFactor = bf;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void printBalanceFactor(TreeNode node) {
        if (node == null) return;
        printBalanceFactor(node.left);

        int bf = height(node.left) - height(node.right);
        System.out.println("節點 " + node.val + " 的平衡因子: " + bf);

        printBalanceFactor(node.right);
    }

    private static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(30);

        System.out.println("是否為平衡樹: " + isBalanced(root));

        System.out.println("\n所有節點的平衡因子:");
        printBalanceFactor(root);

        TreeNode unbalanced = findMostUnbalancedNode(root);
        int bf = height(unbalanced.left) - height(unbalanced.right);
        System.out.println("\n最不平衡節點: " + unbalanced.val + ", 平衡因子: " + bf);
    }
}
