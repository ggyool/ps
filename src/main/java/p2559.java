public class p2559 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] vowelCount = new int[words.length];
        vowelCount[0] = isSideVowel(words[0]) ? 1 : 0;
        for (int i = 1; i < words.length; i++) {
            vowelCount[i] = vowelCount[i - 1];
            if (isSideVowel(words[i])) {
                vowelCount[i]++;
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            ans[i] = vowelCount[to];
            if (from - 1 >= 0) {
                ans[i] -= vowelCount[from - 1];
            }
        }
        return ans;
    }

    private boolean isSideVowel(String s) {
        return isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
