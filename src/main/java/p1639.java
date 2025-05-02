import java.util.Arrays;

public class p1639 {

    final int MOD = 1_000_000_007;

    public int numWays(String[] words, String target) {
        int tlen = target.length();
        int wlen = words[0].length();
        int[][] cache = new int[tlen + 1][wlen + 1];
        for (int i = 0; i < tlen + 1; i++) {
            Arrays.fill(cache[i], -1);
        }
        // idx, char
        int[][] freq = new int[wlen][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < wlen; j++) {
                int idx = words[i].charAt(j) - 'a';
                freq[j][idx]++;
            }
        }
        return solve(0, 0, words, target, cache, freq);
    }

    // taretIdx, idx
    private int solve(int targetIdx, int idx, String[] words, String target, int[][] cache, int[][] freq) {
        if (targetIdx >= target.length()) {
            return 1;
        }
        if (idx >= words[0].length()) {
            return 0;
        }
        if (cache[targetIdx][idx] != -1) {
            return cache[targetIdx][idx];
        }
        // idx 에서 선택하지 않는 경우
        long ret = solve(targetIdx, idx + 1, words, target, cache, freq);

        // idx에서 선택하는 경우
        char targetC = target.charAt(targetIdx);
        ret += ((long) freq[idx][targetC - 'a']) * solve(targetIdx + 1, idx + 1, words, target, cache, freq);
        ret %= MOD;
        cache[targetIdx][idx] = (int) ret;
        return cache[targetIdx][idx];
    }
}


// 첫 풀이 시간 초과
//public class p1639 {
//
//    final int MOD = 1_000_000_007;
//
//    public int numWays(String[] words, String target) {
//        int tlen = target.length();
//        int wlen = words[0].length();
//        int[][] cache = new int[tlen + 1][wlen + 1];
//        for (int i = 0; i < tlen + 1; i++) {
//            Arrays.fill(cache[i], -1);
//        }
//        return solve(0, 0, words, target, cache);
//    }
//
//    // taretIdx, idx
//    private int solve(int targetIdx, int idx, String[] words, String target, int[][] cache) {
//        if (targetIdx >= target.length()) {
//            return 1;
//        }
//        if (idx >= words[0].length()) {
//            return 0;
//        }
//        if (cache[targetIdx][idx] != -1) {
//            return cache[targetIdx][idx];
//        }
//        char targetC = target.charAt(targetIdx);
//        // idx 에서 선택하지 않는 경우
//        int ret = solve(targetIdx, idx + 1, words, target, cache);
//
//        // idx에서 선택하는 경우
//        for (int i = 0; i < words.length; i++) {
//            if (words[i].charAt(idx) == targetC) {
//                ret += solve(targetIdx + 1, idx + 1, words, target, cache);
//                ret %= MOD;
//            }
//        }
//        cache[targetIdx][idx] = ret;
//        return ret;
//    }
//}
