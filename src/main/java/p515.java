import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class p515 {

    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // level, maxValue
        LinkedHashMap<Integer, Integer> mp = new LinkedHashMap<>();
        dfs(0, root, mp);
        return new ArrayList(mp.values());
    }

    void dfs(int level, TreeNode node, LinkedHashMap<Integer, Integer> mp) {
        mp.put(level, Math.max(mp.getOrDefault(level, node.val), node.val));
        if (node.left != null) {
            dfs(level + 1, node.left, mp);
        }
        if (node.right != null) {
            dfs(level + 1, node.right, mp);
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
