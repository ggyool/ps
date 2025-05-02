public class c2379 {
    public int minimumRecolors(String blocks, int k) {
        int maxCnt = 0;
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            char c = blocks.charAt(i);
            if (c == 'B') {
                cnt++;
            }
        }
        maxCnt = cnt;

        for (int i = k; i < blocks.length(); i++) {
            char c = blocks.charAt(i);
            char bc = blocks.charAt(i - k);
            if (c == 'B') {
                cnt++;
            }
            if (bc == 'B') {
                cnt--;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return k - maxCnt;
    }
}
