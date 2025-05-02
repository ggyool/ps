import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p873 {

    // 집중하여 다시 풀어서 pass는 했는데 겁나 느림 정해가 아님 - n이 1000이고 복잡도는 n**2인데 왜 느린지 몰겠다.
    // 정답으로 제공해준 풀이도 제출해보니 같은 n**2이라 느림. 다른 꼼수 풀이가있는듯
    public int lenLongestFibSubseq(int[] arr) {
        int ans = 0;
        Set<Integer> st = new HashSet<>();
        for (int i=0; i<arr.length; i++) {
            st.add(arr[i]);
        }
        Map<Pair, Integer> mp = new HashMap<>();
        for (int i=0; i<arr.length-1; i++) {
            for (int j=i+1; j<arr.length; j++) {
                int a = arr[i];
                int b = arr[j];
                Integer v = mp.getOrDefault(new Pair(a, b), 2);
                if (st.contains(a+b)) {
                    mp.put(new Pair(b, a+b), v+1);
                    int c = a+b;
                    int d = v+1;
                    ans = Math.max(ans, v+1);
                }
            }
        }
        return ans;
    }

    record Pair(int a, int b) {}

    // 첫풀이 시간초과 실패
//    public int lenLongestFibSubseq(int[] arr) {
//        // 증가하는 수열이라서 가능
//        Set<Integer> visited = new HashSet<>();
//        Map<Info, Integer> dp = new HashMap<>();
//        visited.add(arr[0]);
//        visited.add(arr[1]);
//        for (int i = 2; i < arr.length; i++) {
//            int num = arr[i];
//            visited.add(num);
//            for (int j = i - 1; j >= 0; j--) {
//                int b = arr[j];
//                int a = num - num;
//                if (a >= b) break;
//                solve(b, num, visited, dp);
//            }
//        }
//        int ans = 0;
//        for (Integer v : dp.values()) {
//            ans = Math.max(ans, v);
//        }
//        if (ans <= 2) ans = 0;
//        return ans;
//    }
//
//    int solve(int a, int b, Set<Integer> visited, Map<Info, Integer> dp) {
//        if (a >= b) {
//            return 1;
//        }
//        if (!visited.contains(a)) {
//            return 1;
//        }
//        Integer v = dp.get(new Info(a, b));
//        if (v != null) {
//            return v;
//        }
//        Integer res = 1 + solve(b - a, a, visited, dp);
//        dp.put(new Info(a, b), res);
//        return res;
//    }
//
//    record Info(int a, int b) {
//    }
}
