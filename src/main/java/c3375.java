import java.util.HashSet;
import java.util.Set;

public class c3375 {

    // editorial 풀이
    public int minOperations(int[] nums, int k) {
        Set<Integer> st = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            } else if (x > k) {
                st.add(x);
            }
        }
        return st.size();
    }

    // 첫 풀이
//    public int minOperations(int[] nums, int k) {
//        boolean[] exists = new boolean[101];
//        int len = nums.length;
//        for (int i=0; i<len; i++){
//            exists[nums[i]] = true;
//        }
//        int cnt = 0;
//        for (int i=1; i<k; i++) {
//            if (exists[i]) {
//                cnt++;
//            }
//        }
//        if (cnt>0) return -1;
//        cnt = 0;
//        for (int i=k+1; i<101; i++) {
//            if (exists[i]) {
//                cnt++;
//            }
//        }
//        return cnt;
//    }
}
