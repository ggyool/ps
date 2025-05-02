public class c1399 {
    public int countLargestGroup(int n) {
        int[] cnt = new int[37];
        for (int i = 1; i <= n; i++) {
            int sum = digitsSum(i);
            cnt[sum]++;
        }
        int maxSum = 0;
        for (int i = 1; i <= 36; i++) {
            maxSum = Math.max(maxSum, cnt[i]);
        }
        int ans = 0;
        for (int i = 1; i <= 36; i++) {
            if (cnt[i] == maxSum) {
                ans++;
            }
        }
        return ans;
    }

    private int digitsSum(int n) {
        int ret = 0;
        while (n > 0) {
            ret += (n % 10);
            n /= 10;
        }
        return ret;
    }
}
