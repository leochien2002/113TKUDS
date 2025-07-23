import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    public static int distanceFromRoot(TreeNode root, TreeNode target) {
        return dfsDistance(root, target, 0);
    }

    private static int dfsDistance(TreeNode node, TreeNode target, int dist) {
        if (node == null) return -1;
        if (node == target) return dist;

        int left = dfsDistance(node.left, target, dist + 1);
        if (left != -1) return left;
        return dfsDistance(node.right, target, dist + 1);
    }

    public static int distanceBetweenNodes(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = lowestCommonAncestor(root, p, q);
        int distP = distanceFromRoot(root, p);
        int distQ = distanceFromRoot(root, q);
        int distLca = distanceFromRoot(root, lca);
        return distP + distQ - 2 * distLca;
    }

    static class DiameterResult {
        int diameter = 0;
    }

    public static int treeDiameter(TreeNode root) {
        DiameterResult res = new DiameterResult();
        heightAndDiameter(root, res);
        return res.diameter;
    }

    private static int heightAndDiameter(TreeNode node, DiameterResult res) {
        if (node == null) return 0;
        int leftH = heightAndDiameter(node.left, res);
        int rightH = heightAndDiameter(node.right, res);
        res.diameter = Math.max(res.diameter, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }

    public static List<TreeNode> nodesAtDistanceK(TreeNode root, int k) {
        List<TreeNode> res = new ArrayList<>();
        findNodesAtDistanceK(root, k, res);
        return res;
    }

    private static void findNodesAtDistanceK(TreeNode node, int k, List<TreeNode> res) {
        if (node == null) return;
        if (k == 0) {
            res.add(node);
            return;
        }
        findNodesAtDistanceK(node.left, k - 1, res);
        findNodesAtDistanceK(node.right, k - 1, res);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode node4 = root.left.left;
        TreeNode node6 = root.right.right;

        int dist = distanceBetweenNodes(root, node4, node6);
        System.out.println("節點 4 和節點 6 的距離: " + dist);

        int diameter = treeDiameter(root);
        System.out.println("樹的直徑: " + diameter);

        List<TreeNode> dist2Nodes = nodesAtDistanceK(root, 2);
        System.out.print("距離根節點 2 的節點有: ");
        for (TreeNode n : dist2Nodes) {
            System.out.print(n.val + " ");
        }
        System.out.println();
    }
}
