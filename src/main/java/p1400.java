public class p1400 {
    public boolean canConstruct(String s, int k) {
        // 최소 홀수개 최대는? 문자의 개수?
        int[] freq = new int[26];
        for (int i=0; i<s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int oddCnt = 0;
        for (int i=0; i<26; i++) {
            if (freq[i]%2==1) {
                oddCnt++;
            }
        }
        return oddCnt <= k && k <= s.length();
    }
}
