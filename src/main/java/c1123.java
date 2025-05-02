import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class c1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).root;
    }

    private Pair dfs(TreeNode cur) {
        if (cur == null) {
            return new Pair(cur, 0);
        }
        Pair left = dfs(cur.left);
        Pair right = dfs(cur.right);

        if (left.maxDepth > right.maxDepth) {
            return new Pair(left.root, left.maxDepth + 1);
        }
        if (left.maxDepth < right.maxDepth) {
            return new Pair(right.root, right.maxDepth + 1);
        }
        return new Pair(cur, left.maxDepth + 1);
    }

    private record Pair(TreeNode root, int maxDepth) {}

//    private Pair<TreeNode, Integer> dfs(TreeNode root) {
//        if (root == null) {
//            return new Pair<>(null, 0);
//        }
//
//        Pair<TreeNode, Integer> left = dfs(root.left);
//        Pair<TreeNode, Integer> right = dfs(root.right);
//
//        if (left.getValue() > right.getValue()) {
//            return new Pair<>(left.getKey(), left.getValue() + 1);
//        }
//        if (left.getValue() < right.getValue()) {
//            return new Pair<>(right.getKey(), right.getValue() + 1);
//        }
//        return new Pair<>(root, left.getValue() + 1);
//    }


    // 직관으로 빠르게 시도해서 풀었는데 구현+디버깅 20분정도 걸림
    // n이 작아서 4ms 걸리는데 너무 복잡하게 풀었음.
    // editorial 코드는 짧고 시간도 1ms 걸리는듯
//    public TreeNode lcaDeepestLeaves(TreeNode root) {
//        // 가장 깉은 depth를 구하고 그 노드들에서 bfs 하면서 올라온다.
//        Map<Integer, Integer> depthMap = new HashMap<>();
//        Map<Integer, TreeNode> parentMap = new HashMap<>();
//        Map<Integer, TreeNode> nodeMap = new HashMap<>();
//        depthMap.put(root.val, 0);
//        dfs(root, 0, depthMap, parentMap, nodeMap);
//
//        int nodeValue = bfs(depthMap, parentMap, nodeMap);
//        return nodeMap.get(nodeValue);
//    }
//
//    void dfs(TreeNode root, int depth, Map<Integer, Integer> depthMap, Map<Integer, TreeNode> parentMap, Map<Integer, TreeNode> nodeMap) {
//        nodeMap.put(root.val, root);
//        if (root.left != null) {
//            depthMap.put(root.left.val, depth + 1);
//            parentMap.put(root.left.val, root);
//            dfs(root.left, depth + 1, depthMap, parentMap, nodeMap);
//        }
//        if (root.right != null) {
//            depthMap.put(root.right.val, depth + 1);
//            parentMap.put(root.right.val, root);
//            dfs(root.right, depth + 1, depthMap, parentMap, nodeMap);
//        }
//    }
//
//    int bfs(Map<Integer, Integer> depthMap, Map<Integer, TreeNode> parentMap, Map<Integer, TreeNode> nodeMap) {
//        int maxDepth = 0;
//        for (Map.Entry<Integer, Integer> ent : depthMap.entrySet()) {
//            maxDepth = Math.max(maxDepth, ent.getValue());
//        }
//        int[] cnt = new int[1001];
//        Queue<TreeNode> q = new LinkedList<>();
//        for (Map.Entry<Integer, Integer> ent : depthMap.entrySet()) {
//            if (maxDepth == ent.getValue()) {
//                TreeNode node = nodeMap.get(ent.getKey());
//                q.add(node);
//                cnt[node.val]++;
//            }
//        }
//        int target = q.size();
//        while (!q.isEmpty()) {
//            TreeNode cur = q.poll();
//            TreeNode next = parentMap.get(cur.val);
//            if (cnt[cur.val] == target) {
//                return cur.val;
//            }
//            if (next == null) continue;
//            cnt[next.val]++;
//            q.add(next);
//        }
//        return 0;
//    }


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
