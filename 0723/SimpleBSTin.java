public class SimpleBSTin {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 搜尋值
    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;

        if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void main(String[] args) {
        // 手動建立一個含8個節點的BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);
        root.left.left.left = new TreeNode(10);  // 加第8個節點

        // 搜尋兩個值（60存在、35不存在）
        System.out.println("搜尋 60: " + search(root, 60));  // true
        System.out.println("搜尋 35: " + search(root, 35));  // false
    }
}
