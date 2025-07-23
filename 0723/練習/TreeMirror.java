public class TreeMirror {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    public static void mirror(TreeNode root) {
        if (root == null) return;

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.data == b.data &&
               isMirror(a.left, b.right) &&
               isMirror(a.right, b.left);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        System.out.println("是否對稱: " + isSymmetric(root));

        mirror(root);
        System.out.print("鏡像後中序遍歷: ");
        printInOrder(root);

        System.out.println();

        TreeNode t1 = new TreeNode(4);
        t1.left = new TreeNode(5);
        t1.right = new TreeNode(6);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(6);
        t2.right = new TreeNode(5);

        System.out.println("t1 和 t2 是否互為鏡像: " + isMirror(t1, t2)); // true
    }
}
