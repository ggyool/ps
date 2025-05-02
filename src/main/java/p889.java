import java.util.*;
import java.util.stream.Collectors;

public class p889 {

    // 첫 풀이 따라한 코드
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return solve(0, preorder.length-1, 0, preorder, postorder);
    }

    private TreeNode solve(int pre, int end, int post, int[] preorder, int[] postorder) {
        if (pre > end) return null;
        TreeNode root = new TreeNode(preorder[pre]);
        if (pre == end) {
            return root;
        }
        
        // 이 부분 반복 안돌리고 미리 인덱스 위치 계산해 놓는게 두번쨰 풀이임
        int i=0;
        while (true) {
            if (preorder[pre+1] == postorder[post+i]) {
                break;
            }
            i++;
        }
        root.left = solve(pre+1, pre+i+1, post, preorder, postorder);
        root.right = solve(pre+i+2, end, post+i+1, preorder, postorder);
        return root;
    }


    // 첫 풀이
//    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
//        List<Integer> pre = Arrays.stream(preorder).boxed().toList();
//        List<Integer> post = Arrays.stream(postorder).boxed().toList();
//        return solve(pre, post);
//    }
//
//    TreeNode solve(List<Integer> pre, List<Integer> post) {
//        if (pre.isEmpty()) {
//            return null;
//        }
//        TreeNode root = new TreeNode(pre.get(0));
//        if (pre.size() == 1) {
//            return root;
//        }
//        Map<Integer, Integer> mp = new HashMap<>();
//        int iter=1;
//        int i=1;
//        int j=0;
//        int cnt=0;
//        while (true) {
//            mp.put(pre.get(i), mp.getOrDefault(pre.get(i), 0) + 1);
//            if (mp.get(pre.get(i)) == 2) {
//                cnt++;
//            }
//            mp.put(post.get(j), mp.getOrDefault(post.get(j), 0) + 1);
//            if (mp.get(post.get(j)) == 2) {
//                cnt++;
//            }
//            if (cnt == iter) {
//                break;
//            }
//            i++;
//            j++;
//            iter++;
//        }
//        root.left = solve(pre.subList(1, i+1), post.subList(0, j+1));
//        root.right = solve(pre.subList(i+1, pre.size()), post.subList(j+1, post.size()-1));
//        return root;
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
