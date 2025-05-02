public class c1358 {

    public int numberOfSubstrings(String s) {
        int a = 0, b = 0, c = 0;
        int j = 0;
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            while (j < len && !isSatisfied(a, b, c)) {
                char ch = s.charAt(j);
                if (ch == 'a') a++;
                else if (ch == 'b') b++;
                else if (ch == 'c') c++;
                j++;
            }
            if (isSatisfied(a, b, c)) ans += (len - j + 1);
            char ch = s.charAt(i);
            if (ch == 'a') a--;
            else if (ch == 'b') b--;
            else if (ch == 'c') c--;

        }
        return ans;
    }

    private boolean isSatisfied(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0;
    }

    // 첫 풀이
//    public int numberOfSubstrings(String s) {
//        Queue<Integer> qa = new LinkedList<>();
//        Queue<Integer> qb = new LinkedList<>();
//        Queue<Integer> qc = new LinkedList<>();
//        for (int i=0; i<s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == 'a') qa.add(i);
//            else if (c == 'b') qb.add(i);
//            else if (c == 'c') qc.add(i);
//        }
//        int len = s.length();
//        int ans = 0;
//        for (int i=0; i<len; i++) {
//            while (!qa.isEmpty() && qa.peek()<i) qa.poll();
//            while (!qb.isEmpty() && qb.peek()<i) qb.poll();
//            while (!qc.isEmpty() && qc.peek()<i) qc.poll();
//            if (qa.isEmpty() || qb.isEmpty() || qc.isEmpty()) break;
//            int a = qa.peek();
//            int b = qb.peek();
//            int c = qc.peek();
//            int maxIdx = Math.max(a, Math.max(b, c));
//            ans += (len - maxIdx);
//        }
//        return ans;
//    }
}
