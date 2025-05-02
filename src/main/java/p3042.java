public class p3042 {
    public int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        int wlen = words.length;
        for (int i = 0; i < wlen - 1; i++) {
            for (int j = i + 1; j < wlen; j++) {
                String a = words[i];
                String b = words[j];
                if (a.length() > b.length()) continue;
                if (isPrefixAndSuffix(a, b)) ans++;
            }
        }
        return ans;
    }

    private boolean isPrefixAndSuffix(String shortWord, String longWord) {
        int shortLen = shortWord.length();
        int longLen = longWord.length();
        for (int i = 0; i < shortLen; i++) {
            if (
                    shortWord.charAt(i) != longWord.charAt(i) ||
                            shortWord.charAt(shortLen - i - 1) != longWord.charAt(longLen - i - 1)
            ) {
                return false;
            }
        }
        return true;
    }
}
