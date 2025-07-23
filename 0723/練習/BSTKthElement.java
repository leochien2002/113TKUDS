public class BSTKthElement {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    static class Counter {
        int k;
        int result;

        Counter(int k) {
            this.k = k;
        }
    }

    public static int findKthSmallest(TreeNode root, int k) {
        Counter counter = new Counter(k);
        inOrderFind(root, counter);
        return counter.result;
    }

    private static void inOrderFind(TreeNode node, Counter counter) {
        if (node == null || counter.k == 0) return;

        inOrderFind(node.left, counter);

        if (--counter.k == 0) {
            counter.result = node.data;
            return;
        }

        inOrderFind(node.right, counter);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right.left = new TreeNode(25);
        root.right.right = new TreeNode(35);

        int k = 3;
        int result = findKthSmallest(root, k);
        System.out.println("第 " + k + " 小的元素是: " + result);
    }
}
