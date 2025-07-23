
public class BSTConversion {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode bstToDoublyLinkedList(TreeNode root) {
        if (root == null) return null;

        TreeNode head = null, tail = null;
        inorderTraversal(root, head, tail);

        return head;
    }

    private static void inorderTraversal(TreeNode node, TreeNode head, TreeNode tail) {
        if (node == null) return;

        inorderTraversal(node.left, head, tail);

        if (tail == null) {
            head = node;
        } else {
            tail.right = node;
            node.left = tail;
        }
        tail = node;

        inorderTraversal(node.right, head, tail);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBSTHelper(nums, left, mid - 1);
        root.right = sortedArrayToBSTHelper(nums, mid + 1, right);

        return root;
    }

    public static void convertBST(TreeNode root) {
        int[] sum = {0};
        reverseInOrderTraversal(root, sum);
    }

    private static void reverseInOrderTraversal(TreeNode node, int[] sum) {
        if (node == null) return;

        reverseInOrderTraversal(node.right, sum);

        sum[0] += node.val;
        node.val = sum[0];

        reverseInOrderTraversal(node.left, sum);
    }

    public static void inorderPrint(TreeNode node) {
        if (node == null) return;
        inorderPrint(node.left);
        System.out.print(node.val + " ");
        inorderPrint(node.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println("將 BST 轉換為排序的雙向鏈表:");
        TreeNode head = bstToDoublyLinkedList(root);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();

        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("將排序陣列轉換為平衡的 BST:");
        TreeNode balancedBST = sortedArrayToBST(sortedArray);
        inorderPrint(balancedBST);
        System.out.println();

        System.out.println("將每個節點值改為大於等於該節點值的總和:");
        convertBST(root);
        inorderPrint(root);
        System.out.println();
    }
}
