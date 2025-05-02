public class p1524 {

    final int MOD = 1_000_000_007;

    public int numOfSubarrays(int[] arr) {
        // 첫 풀이 - 떠올리는데 한참 걸림
        // i로 시작하는 홀 짝 수 구해서 뒤부터 내려옴
        int n = arr.length;
        int[] oddCnt = new int[n];
        int[] evenCnt = new int[n];
        if (arr[n - 1] % 2 == 1) {
            oddCnt[n - 1] = 1;
        } else {
            evenCnt[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] % 2 == 1) {
                oddCnt[i] = 1 + evenCnt[i + 1];
                evenCnt[i] = oddCnt[i + 1];
            } else {
                oddCnt[i] = oddCnt[i + 1];
                evenCnt[i] = 1 + evenCnt[i + 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += oddCnt[i];
            ans %= MOD;
        }
        return ans;
    }
}
