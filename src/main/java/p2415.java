import java.util.LinkedList;

public class p2415 {

    public TreeNode reverseOddLevels(TreeNode root) {
        var q = new LinkedList<TreeNode>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            if (level % 2 == 0) {
                for (int i = 0; i < len; ++i) {
                    var cur = q.poll();
                    if (cur.left != null) q.add(cur.left);
                    if (cur.right != null) q.add(cur.right);
                }
            } else {
                var values = new int[len];
                for (int i = 0; i < len; ++i) {
                    var cur = q.poll();
                    values[i] = cur.val;
                    q.add(cur);
                }
                for (int i = 0; i < len; ++i) {
                    var cur = q.poll();
                    if (cur.left != null) q.add(cur.left);
                    if (cur.right != null) q.add(cur.right);
                    cur.val = values[len - i - 1];
                }
            }
            level++;
        }
        return root;
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
