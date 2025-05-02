import java.util.*;

public class p1462 {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // 여러번 탐색하지 않는것이 포인트라 셋에 저장해두고 사용
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int plen = prerequisites.length;
        for (int i = 0; i < plen; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            adj.get(from).add(to);
        }
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            recur(i, adj, mp);
        }
        List<Boolean> ans = new ArrayList<>();
        int qlen = queries.length;
        for (int i = 0; i < qlen; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            ans.add(mp.get(from).contains(to));
        }
        return ans;
    }

    Set<Integer> recur(int cur, List<List<Integer>> adj, Map<Integer, Set<Integer>> mp) {
        if (mp.containsKey(cur)) {
            return mp.get(cur);
        }
        HashSet<Integer> tmpSt = new HashSet<>();
        tmpSt.add(cur);
        int len = adj.get(cur).size();
        for (int i = 0; i < len; i++) {
            int next = adj.get(cur).get(i);
            tmpSt.addAll(recur(next, adj, mp));
        }
        mp.put(cur, tmpSt);
        return tmpSt;
    }
}
