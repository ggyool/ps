public class p769 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int maxN = -1;
        for (int i = 0; i < arr.length; i++) {
            maxN = Math.max(arr[i], maxN);
            if (maxN == i) {
                ans += 1;
                maxN = -1;
            }
        }
        return ans;
    }
}
