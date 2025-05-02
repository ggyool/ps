package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 비밀코드해독 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        List<List<Integer>> candidate = new ArrayList<>();
        pick(1, 5, n, new ArrayList<>(), candidate);
        for (int i = 0; i < candidate.size(); i++) {
            List<Integer> candi = candidate.get(i);
            if (check(candi, q, ans)) {
                answer++;
            }
        }
        return answer;
    }

    boolean check(List<Integer> candi, int[][] q, int[] ans) {
        Set<Integer> candiSet = new HashSet<>(candi);
        for (int i = 0; i < q.length; i++) {
            int[] query = q[i];
            int cnt = 0;
            for (int j = 0; j < query.length; j++) {
                if (candiSet.contains(query[j])) cnt++;
            }
            if (cnt != ans[i]) return false;
        }
        return true;
    }

    void pick(int cur, int cnt, int n, List<Integer> lst, List<List<Integer>> candidate) {
        if (cnt == 0) {
            candidate.add(new ArrayList<>(lst));
            return;
        }
        if (cur > n) return;
        for (int i = cur; i <= n; i++) {
            lst.add(i);
            pick(i + 1, cnt - 1, n, lst, candidate);
            lst.remove(lst.size() - 1);
        }
    }
}
