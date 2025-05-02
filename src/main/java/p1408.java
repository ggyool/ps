import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p1408 {
    public List<String> stringMatching(String[] words) {
        Set<String> st = new HashSet<>();
        int wlen = words.length;
        for (int i = 0; i < wlen - 1; i++) {
            for (int j = i + 1; j < wlen; j++) {
                String s = subString(words[i], words[j]);
                if (s != null) {
                    st.add(s);
                }
            }
        }
        return new ArrayList<>(st);
    }


    private String subString(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        if (alen < blen) {
            if (b.contains(a)) {
                return a;
            }
        }
        if (a.contains(b)) {
            return b;
        }
        return null;
    }
}
