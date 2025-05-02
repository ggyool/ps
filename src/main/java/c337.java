import java.util.HashMap;

public class c337 {

    // 정답 코드
//    public int rob(TreeNode root) {
//        int[] ret = solve(root);
//        return Math.max(ret[0], ret[1]);
//    }
//
//    public int[] solve(TreeNode node) {
//        if (node == null) {
//            return new int[]{0,0};
//        }
//        int[] leftRes = solve(node.left);
//        int[] rightRes = solve(node.right);
//        int[] ret = new int[]{0,0};
//        ret[0] = node.val + leftRes[1] + rightRes[1];
//        ret[1] = Math.max(leftRes[0], leftRes[1]) + Math.max(rightRes[0], rightRes[1]);
//        return ret;
//    }

    // 메모이제이션 없이는 시간 초과나서 다른 풀이들을 보기 위해 문자열로 대강해서 pass
    HashMap<String, Integer> dp = new HashMap<>();

    public int rob(TreeNode root) {
        return solve(root, false, "");
    }

    private int solve(TreeNode cur, boolean parentSelected, String traversal) {
        if (cur == null) {
            return 0;
        }
        String key = traversal + parentSelected;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int ret = solve(cur.left, false, traversal + "l") + solve(cur.right, false, traversal + "r");

        if (!parentSelected) {
            ret = Math.max(
                    ret,
                    cur.val + solve(cur.left, true, traversal + "l") + solve(cur.right, true, traversal + "r")
            );
        }
        dp.put(key, ret);
        return ret;
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
