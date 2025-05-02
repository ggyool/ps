import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p1028 {

    static int index = 0;

    public TreeNode recoverFromPreorder(String traversal) {
        index = 0;
        return helper(traversal, 0);
    }

    private TreeNode helper(String traversal, int depth) {
        if (index >= traversal.length()) return null;
        // Count the number of dashes
        int dashCount = 0;
        while (
                (index + dashCount) < traversal.length() &&
                        traversal.charAt(index + dashCount) == '-'
        ) {
            dashCount++;
        }

        // If the number of dashes doesn't match the current depth, return null
        if (dashCount != depth) return null;

        // Move index past the dashes
        index += dashCount;

        // Extract the node value
        int value = 0;
        while (
                index < traversal.length() &&
                        Character.isDigit(traversal.charAt(index))
        ) {
            value = value * 10 + (traversal.charAt(index++) - '0');
        }

        // Create the current node
        TreeNode node = new TreeNode(value);

        // Recursively build the left and right subtrees
        node.left = helper(traversal, depth + 1);
        node.right = helper(traversal, depth + 1);

        return node;
    }

    // 첫 풀이
//    public TreeNode recoverFromPreorder(String traversal) {
//        List<TreeNode> nodes = new ArrayList<>();
//        List<Integer> levels = new ArrayList<>();
//        StringBuilder sb = new StringBuilder();
//        int level = 0;
//        for (int i = 0; i < traversal.length(); i++) {
//            char c = traversal.charAt(i);
//            if (c >= '0' && c <= '9') {
//                if (level != 0) {
//                    levels.add(level);
//                    level = 0;
//                }
//                sb.append(c);
//            } else {
//                if (!sb.isEmpty()) {
//                    nodes.add(new TreeNode(Integer.valueOf(sb.toString())));
//                    sb = new StringBuilder();
//                }
//                level++;
//            }
//        }
//        nodes.add(new TreeNode(Integer.valueOf(sb.toString())));
//        Map<Integer, TreeNode> depthNodes = new HashMap<>();
//        depthNodes.put(1, nodes.get(0));
//        makeTree(1, 1, nodes, levels, depthNodes);
//        return nodes.get(0);
//    }
//
//    void makeTree(int idx, int depth, List<TreeNode> nodes, List<Integer> levels, Map<Integer, TreeNode> depthNodes) {
//        if (idx == nodes.size()) return;
//        TreeNode cur = depthNodes.get(depth);
//        if (cur == null) return;
//        int level = levels.get(idx - 1);
//        if (depth == level) {
//            if (cur.left == null) {
//                if (idx != nodes.size()) {
//                    cur.left = nodes.get(idx);
//                    depthNodes.put(depth + 1, nodes.get(idx));
//                    makeTree(idx + 1, depth + 1, nodes, levels, depthNodes);
//                }
//            } else if (cur.right == null) {
//                if (idx != nodes.size()) {
//                    cur.right = nodes.get(idx);
//                    depthNodes.put(depth + 1, nodes.get(idx));
//                    makeTree(idx + 1, depth + 1, nodes, levels, depthNodes);
//                }
//            } else {
//                throw new RuntimeException("");
//            }
//        } else {
//            makeTree(idx, depth - 1, nodes, levels, depthNodes);
//        }
//    }

    private class TreeNode {
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
