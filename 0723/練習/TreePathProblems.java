import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        traversePaths(root, new ArrayList<>(), result);
        return result;
    }

    private static void traversePaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            traversePaths(node.left, path, result);
            traversePaths(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return target == root.data;
        }

        int newTarget = target - root.data;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }

    public static List<Integer> maxPathSum(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        maxSumHelper(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, result);
        return result;
    }

    private static void maxSumHelper(TreeNode node, List<Integer> path, int sum,
                                     int[] maxSum, List<Integer> bestPath) {
        if (node == null) return;

        path.add(node.data);
        sum += node.data;

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                bestPath.clear();
                bestPath.addAll(path);
            }
        } else {
            maxSumHelper(node.left, path, sum, maxSum, bestPath);
            maxSumHelper(node.right, path, sum, maxSum, bestPath);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println("所有根到葉的路徑：");
        List<List<Integer>> paths = allPaths(root);
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
        int target = 22;
        System.out.println("\n是否存在總和為 " + target + " 的根到葉路徑: " + hasPathSum(root, target));

        List<Integer> maxPath = maxPathSum(root);
        int maxSum = maxPath.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\n最大總和根到葉路徑: " + maxPath);
        System.out.println("最大總和為: " + maxSum);
    }
}
