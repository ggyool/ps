public class p3223 {
    public int minimumLength(String s) {
        // 3개 이상인 문자면 2개가 남을때까지 지우는게 가능하다
        // 홀수면 1남고 짝수면 2남음
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        int ret = s.length();
        for (int i = 0; i < 26; i++) {
            if (cnt[i] >= 3) {
                if (cnt[i] % 2 == 1) {
                    ret -= (cnt[i] - 1);
                } else {
                    ret -= (cnt[i] - 2);
                }

            }
        }
        return ret;
    }
}
