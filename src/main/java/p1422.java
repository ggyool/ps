public class p1422 {
    public int maxScore(String s) {
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                oneCnt++;
            }
        }
        if (s.charAt(0) == '1') {
            oneCnt--;
        } else {
            zeroCnt++;
        }
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            ans = Math.max(ans, zeroCnt + oneCnt);
            if (s.charAt(i) == '1') {
                oneCnt--;
            } else {
                zeroCnt++;
            }
        }
        return ans;
    }
}
