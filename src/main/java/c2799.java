import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class c2799 {

    // 투포인터로 수정 (9ms)
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        int len = nums.length;
        Set<Integer> totalSt = new HashSet<>();
        for (int i=0; i<len; i++) {
            totalSt.add(nums[i]);
        }
        int distinctCount = totalSt.size();
        int j = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i=0; i<len; i++) {
            while (j < len && mp.size() < distinctCount) {
                mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);
                j++;
            }
            if (mp.size() == distinctCount) {
                ans += (len - j + 1);
            }
            int befCount = mp.get(nums[i]);
            if (befCount == 1) {
                mp.remove(nums[i]);
            } else {
                mp.put(nums[i], befCount - 1);
            }
        }
        return ans;
    }

    // 카운트만 체크하는걸로 살짝 바꿨는데 여전히 느림 (258ms)
//    public int countCompleteSubarrays(int[] nums) {
//        int ans = 0;
//        Set<Integer> totalSt = new HashSet<>();
//        for (int i=0; i<nums.length; i++) {
//            totalSt.add(nums[i]);
//        }
//        int distinctCount = totalSt.size();
//        for (int i=0; i<nums.length; i++) {
//            Set<Integer> st =new HashSet<>();
//            for (int j=i; j< nums.length; j++) {
//                st.add(nums[j]);
//                if (st.size() == distinctCount) {
//                    ans += nums.length - j;
//                    break;
//                }
//            }
//        }
//        return ans;
//    }

    // 시간 초과 날 거라 생각해고 제출했느데 엄청 느리게 통과 (722ms)
//    public int countCompleteSubarrays(int[] nums) {
//        int ans = 0;
//        Set<Integer> totalSt = new HashSet<>();
//        for (int i=0; i<nums.length; i++) {
//            totalSt.add(nums[i]);
//        }
//        for (int i=0; i<nums.length; i++) {
//            Set<Integer> st = new HashSet<>();
//            for (int j=i; j< nums.length; j++) {
//                st.add(nums[j]);
//                if (totalSt.equals(st)) {
//                    ans++;
//                }
//            }
//        }
//        return ans;
//    }
}
