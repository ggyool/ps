public class p1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length();
        int a = -1;
        int b = -1;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (a == -1) {
                    a = i;
                } else if (b == -1) {
                    b = i;
                } else {
                    return false;
                }
            }
        }
        if (a == -1 && b == -1) return true;
        if (a == -1 || b == -1) return false;
        return s1.charAt(a) == s2.charAt(b) && s2.charAt(a) == s1.charAt(b);
    }
}
