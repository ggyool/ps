import java.util.HashSet;
import java.util.Set;

public class p1261 {

    private static class FindElements {
        Set<Integer> st = new HashSet<>();

        // 채우면서 value 저장하자.
        public FindElements(TreeNode root) {
            root.val = 0;
            st.add(0);
            fill(root);
        }

        private void fill(TreeNode cur) {
            if (cur.left != null) {
                cur.left.val = cur.val * 2 + 1;
                st.add(cur.val * 2 + 1);
                fill(cur.left);
            }
            if (cur.right != null) {
                cur.right.val = cur.val * 2 + 2;
                st.add(cur.val * 2 + 2);
                fill(cur.right);
            }
        }

        public boolean find(int target) {
            return st.contains(target);
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
