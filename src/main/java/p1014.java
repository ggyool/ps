public class p1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int len = values.length;
        int[] arr = new int[len];
        arr[0] = values[0];
        for (int i = 1; i < len; i++) {
            arr[i] = Math.max(arr[i - 1], values[i] + i);
        }

        int ans = 0;
        for (int j = 1; j < len; j++) {
            ans = Math.max(ans, arr[j - 1] + values[j] - j);
        }
        return ans;
    }
}
