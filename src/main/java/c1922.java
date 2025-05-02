public class c1922 {
    private static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        // 소수 개수 4개 2,3,5,7
        // 짝수 개수 5개 0,2,4,6,8
        return (int) ((power(4, n / 2) * power(5, (n + 1) / 2)) % MOD);
    }

    private long power(long x, long y) {
        long ret = 1L;
        long mul = x;
        while (y > 0) {
            if (y % 2 == 1) {
                ret *= mul;
                ret %= MOD;
            }
            mul *= mul;
            mul %= MOD;

            y /= 2;
        }
        return ret;
    }
}
