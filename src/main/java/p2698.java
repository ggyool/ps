public class p2698 {
    public int punishmentNumber(int n) {
        int ret = 1;
        for (int i = 9; i <= n; i++) {
            if (sliceSum(0, String.valueOf(i * i), 0, i)) {
                ret += (i * i);
            }
        }
        return ret;
    }

    boolean sliceSum(int idx, String s, int sum, int target) {
        if (idx >= s.length()) {
            return sum == target;
        }
        // i : 길이
        for (int i = 1; i <= s.length() - idx; i++) {
            int cur = Integer.valueOf(s.substring(idx, idx + i));
            if (sliceSum(idx + i, s, sum + cur, target)) {
                return true;
            }
        }
        return false;
    }
}
