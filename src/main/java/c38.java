public class c38 {
    public String countAndSay(int n) {
        return solve(n);
    }

    private String solve(int n) {
        if (n == 1) return "1";
        System.out.println(n);
        String bef = solve(n - 1);
        StringBuilder sb = new StringBuilder();
        char cur = ' ';
        int cnt = 0;
        for (int i = 0; i < bef.length(); i++) {
            char c = bef.charAt(i);
            if (c == cur) {
                cur = c;
                cnt++;
            } else {
                if (cur != ' ') {
                    sb.append(cnt);
                    sb.append(cur);
                }
                cur = c;
                cnt = 1;
            }
        }
        sb.append(cnt);
        sb.append(cur);
        return sb.toString();
    }
}
