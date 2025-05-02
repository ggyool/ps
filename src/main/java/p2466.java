public class p2466 {
    public int countGoodStrings(int low, int high, int zero, int one) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 0; i < high; i++) {
            if (i + one <= high) {
                dp[i + one] += dp[i];
                dp[i + one] %= MOD;
            }
            if (i + zero <= high) {
                dp[i + zero] += dp[i];
                dp[i + zero] %= MOD;
            }
        }

        int ans = 0;
        for (int i=low; i<= high; i++ ) {
            ans = (ans + dp[i]) % MOD;
        }
        return ans;
    }
}

// 첫 풀이
//public class p2466 {
//    public int countGoodStrings(int low, int high, int zero, int one) {
//        int[] cache = new int[high + 1];
//        Arrays.fill(cache, -1);
//        return solve(0, low, high, zero, one, cache);
//    }
//
//    private int solve(int l, int low, int high, int zero, int one, int[] cache) {
//        if (l >= high) {
//            return 0;
//        }
//        if (cache[l] != -1) {
//            return cache[l];
//        }
//        int aPlus = 0;
//        if (low <= l + zero && l + zero <= high) aPlus = 1;
//        int a = aPlus + solve(l + zero, low, high, zero, one, cache);
//
//        int bPlus = 0;
//        if (low <= l + one && l + one <= high) bPlus = 1;
//        int b = bPlus  + solve(l + one, low, high, zero, one, cache);
//
//        int res = (a+b) % 1_000_000_007;
//        cache[l] = res;
//        return res;
//    }
//}
