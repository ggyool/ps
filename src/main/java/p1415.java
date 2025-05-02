public class p1415 {

    char[] carr = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        int[] cnt = new int[1];
        cnt[0] = 0;
        return makeString(n, k, cnt, new StringBuilder());
    }

    String makeString(int n, int k, int[] cnt, StringBuilder sb) {
        if (sb.length() == n) {
            cnt[0]++;
            if (cnt[0] == k) {
                return sb.toString();
            }
            return "";
        }

        for (int i = 0; i < 3; i++) {
            char c = carr[i];
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                String ret = makeString(n, k, cnt, sb);
                if (!ret.isEmpty()) return ret;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return "";
    }
}
