import java.util.*;

public class p2471 {

    public int minimumOperations(TreeNode root) {
        // 원래 위치 다른거 -1 이어야 하는데
        // 사이클이 있으면 1 줄어듬
        // 정리하면 사이클이 여러개 잇다고 가정하면
        // 각 사이클 길이 - 1을 누적해서 더해나가야하는듯
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ret = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            List<Info> nums = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
                if (cur == root) break;
                nums.add(new Info(i, cur.val));
            }
            ret += calcMinSwap(nums);
        }
        return ret;
    }

    private int calcMinSwap(List<Info> nums) {
        nums.sort(Comparator.comparingInt(p -> p.val));
        boolean[] visited = new boolean[nums.size()];
        int ret = 0;
        for (int i=0; i< nums.size(); i++) {
            if (visited[i]) continue;
            int tmp = 0;
            int curIdx = i;
            while (true) {
                int nextIdx = nums.get(curIdx).idx;
                if (i == nextIdx || visited[nextIdx]) break;
                visited[nextIdx] = true;
                curIdx = nextIdx;
                tmp++;
            }
            ret += tmp;
        }
        return ret;
    }

    private record Info(int idx, int val) {
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
