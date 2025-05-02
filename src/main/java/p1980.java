import java.util.HashSet;
import java.util.Set;

public class p1980 {

    // 간단 풀이가 있네
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<nums.length; i++) {
            sb.append('1' - nums[i].charAt(i));
        }
        return sb.toString();
    }

    // 첫 풀이
//    public String findDifferentBinaryString(String[] nums) {
//        Set<String> st = new HashSet<>();
//        int n = nums.length;
//        for (int i = 0; i < n; i++) {
//            st.add(nums[i]);
//        }
//        return solve(0, n, st, new StringBuilder());
//    }
//
//    String solve(int idx, int n, Set<String> st, StringBuilder sb) {
//        if (idx == n) {
//            String s = sb.toString();
//            if (st.contains(s)) {
//                return "";
//            } else {
//                return s;
//            }
//        }
//        sb.append('0');
//        String a = solve(idx + 1, n, st, sb);
//        if (!a.isEmpty()) return a;
//        sb.deleteCharAt(sb.length() - 1);
//
//        sb.append('1');
//        String b = solve(idx + 1, n, st, sb);
//        if (!b.isEmpty()) return b;
//        sb.deleteCharAt(sb.length() - 1);
//        return "";
//    }
}
