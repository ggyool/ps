public class p1930 {
    public int countPalindromicSubsequence(String s) {
        int slen = s.length();
        int[][] cnt = new int[slen][26];
        cnt[0][s.charAt(0) - 'a'] = 1;
        for (int i = 1; i < slen; i++) {
            for (int j = 0; j < 26; j++) {
                cnt[i][j] = cnt[i - 1][j];
            }
            cnt[i][s.charAt(i) - 'a']++;
        }
        boolean[][] visited = new boolean[26][26];
        int ans = 0;
        for (int i = 1; i < slen - 1; i++) {
            for (int j = 0; j < 26; j++) {
                int leftCnt = cnt[i - 1][j];
                int rightCnt = cnt[slen - 1][j] - cnt[i][j];
                if (leftCnt > 0 && rightCnt > 0) {
                    int mid = s.charAt(i) - 'a';
                    if (!visited[j][mid]) {
                        visited[j][mid] = true;
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
