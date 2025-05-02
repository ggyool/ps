public class p1079 {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (int i = 0; i < tiles.length(); i++) {
            char c = tiles.charAt(i);
            cnt[c - 'A']++;
        }
        return pick(cnt);
    }

    int pick(int[] cnt) {
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                cnt[i]--;
                ret += 1 + pick(cnt);
                cnt[i]++;
            }
        }
        return ret;
    }
}
